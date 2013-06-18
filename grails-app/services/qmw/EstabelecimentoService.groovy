package qmw

class EstabelecimentoService {

    def criaEstab(params, session, estabelecimentoInstance){
        estabelecimentoInstance.setNolocal(true);
        estabelecimentoInstance.setViagem(true);
        estabelecimentoInstance.setDelivery(true);
        estabelecimentoInstance.setLocalFechamento("1");
        estabelecimentoInstance.setSistemaTrabalho("mesa");
    }

    def enviaEmailNovoEstab(estabelecimentoInstance, destino){
        sendMail {
            from "qmenu@qmenu.com.br"
            to destino
            subject "Novo estabelecimento cadastrado"
            body 'Nome: ' + estabelecimentoInstance.nomefantasia + '\n'+
                    'Documento: ' + estabelecimentoInstance.documento + '\n' +
                    estabelecimentoInstance.senha
        }
    }

    def criarModelo(e) {
        new Usuario(codigo : 'usuario' + e.id, nome: 'Usuário modelo', senha : 'usuario' + e.id, email : e.email, estab : e).save(flush: true)
        new Mesa(numero : '10', estab : e).save(flush: true)
        def ga = GrupoAdicionais.where { estab.id == 1 }
        ga.each{
            new GrupoAdicionais(descricao : it.descricao, estab : e).save(flush: true)
        }
        def a = Adicionais.where { estab.id == 1 }
        a.each{
            new Adicionais(grupoAdicionais: GrupoAdicionais.findByEstabAndDescricao(e, it.grupoAdicionais?.descricao), item : it.item, preco : it.preco, descricaoestab : it.descricaoestab, estab : e).save(flush: true)
        }
        def mp = MenuPrincipal.where { estab.id == 1 }
        mp.each{
            new MenuPrincipal(tipoCobranca : it.tipoCobranca, localAtendimento: it.localAtendimento, qtdeitem: it.qtdeitem,
                    item : it.item, sequencia : it.sequencia, imprimeCupom : it.imprimeCupom, estab : e).save(flush: true)
        }
        def m = Menu.where { estab.id == 1 }
        m.each{
            new Menu(menuPrincipal : MenuPrincipal.findByEstabAndItem(e, it.menuPrincipal.item),
                    sequencia: it.sequencia,
                    grupoAdicionais: GrupoAdicionais.findByEstabAndDescricao(e, it.grupoAdicionais?.descricao),
                    item : it.item, preco : it.preco, descricaoestab : it.descricaoestab, estab : e).save(flush: true)
        }
    }
}
