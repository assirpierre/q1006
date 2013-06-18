package qmw


class PedidoController {
	def pedidoService

	def beforeInterceptor = [action:this.&auth]

	def listreimpressao(Integer max) {
		params.max = Math.min(max ?: 9, 100)
		params.sort='codigo'
		params.order='asc'
		def pedidoInstance = Pedido.where {
			utilizacaoMesa.id == pedidoService.getUPedido(params, session)
		}
		pedidoInstance = pedidoInstance.where {
			codigo == pedidoService.getSeq(pedidoInstance, params)
		}
		def model =[pedidoInstanceList: pedidoInstance.list(params), pedidoInstanceTotal: pedidoInstance.count()]
		if (request.xhr){
			render(template: "reimpressao", model: model)
			render (pedidoService.getJS(pedidoInstance, true))
		}else{
			model
		}
	}
	
	def atualizaServico(Integer max) {
		double servico = -1;
		try{
			if(params['servico']!=null && !params['servico'].equals(""))
				servico = Double.parseDouble(params['servico'].replaceAll(",","."));
		}catch(Exception e){}
		if(servico == -1){
			flash.message = message(code: 'pedido.erroAtualizarServico')
			redirect(action: "listpmesa")
			return
		}else{
			UtilizacaoMesa uM = UtilizacaoMesa.findById(params['pedido'])
			uM.setServico(servico)
			uM.setTotal(servico + uM.subTotal)
			uM.save(flush: true)
			listpmesa(max)
		}
	}
	
	def listpmesa(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		def vvmesa = 0
		if (params['mesa'] != null)
			vvmesa = params['mesa']
		def pedidoInstance = Pedido.where {
			utilizacaoMesa.id == pedidoService.getUPedido(params, session)
		}
		def model =[pedidoInstanceList: pedidoInstance.list(params), pedidoInstanceTotal: pedidoInstance.count()]
		if (request.xhr){
			render(template: "listpmesa", model: model)
			render (pedidoService.getJS(pedidoInstance, false))
		}else
			model
	}

	def listplocal(Integer max) {
		params.max = Math.min(max ?: 10, 100)
		params.sort = 'dataPedido';
		def lAtendimento = params['localAtendimento']
		if (lAtendimento == null)
			lAtendimento = '1'
		def pedidoInstance = Pedido.where {
			estab == session.estab
			and
			situacao == 'C'
			and
			menuPrincipal.localAtendimento == lAtendimento
		}
		def model =[pedidoInstanceList: pedidoInstance.list(params), pedidoInstanceTotal: pedidoInstance.count()]
		if (request.xhr){
			render (template: "listplocal", model: model)
			def pedidoNaoImpresso = pedidoInstance.where {
				cupomImpresso == false
			}
			if(pedidoNaoImpresso.count() > 0){
				Pedido p = pedidoNaoImpresso.list().first();
				render "<script>jQuery('#relatorio')[0].src= '../ImpressaoCupom/pedido?cupomId=" + p.utilizacaoMesa.id  + "&sequencia=" + p.codigo + "';</script>"
			}
			if(session.estab.localFechamento == lAtendimento){
				def fechamentoNaoImpresso = pedidoService.getFechamentoNaoImpresso(session)
				if(fechamentoNaoImpresso)
					render "<script>jQuery('#relatoriofechamento')[0].src= '../ImpressaoCupom/fechamento?cupomId=" + fechamentoNaoImpresso.utilizacaoMesa.id + "';</script>"
			}
		}else
			model

	}
	def atender(Integer max) {
		pedidoService.atender(params)
		listplocal()
	}

	def excluir(Integer max) {
		pedidoService.excluir(params)
		listpmesa()
	}

	def auth() {
		if(!session.estab) {
			render "<script>window.location.href='../';</script>"
			return false
		}
	}
}
