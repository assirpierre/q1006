package qmw

class Pedido {
	int codigo
	int linha
	Date dataPedido
	Date dataAtendimento
	int dispositivo
	double preco
	double qtde
	double precoAdicionais
	double total
	String observacao
	String situacao
	boolean cupomImpresso
	static belongsTo = [estab: Estabelecimento, usuario: Usuario, mesa: Mesa, menuPrincipal: MenuPrincipal, utilizacaoMesa: UtilizacaoMesa,
		item1: Item, item2: Item, item3: Item, item4: Item, item5: Item,
		item6: Item, item7: Item, item8: Item, item9: Item, item10: Item,
		itemadd1: Item, itemadd2: Item, itemadd3: Item, itemadd4: Item, itemadd5: Item,
		itemadd6: Item, itemadd7: Item, itemadd8: Item, itemadd9: Item, itemadd10: Item,
		itemadd11: Item, itemadd12: Item, itemadd13: Item, itemadd14: Item, itemadd15: Item]

	String getItem() {
		String retorno = "$item1";
		if(item2 !=null) retorno+= " / $item2"
		if(item3 !=null) retorno+= " / $item3"
		if(item4 !=null) retorno+= " / $item4"
		if(item5 !=null) retorno+= " / $item5"
		if(item6 !=null) retorno+= " / $item6"
		if(item7 !=null) retorno+= " / $item7"
		if(item8 !=null) retorno+= " / $item8"
		if(item9 !=null) retorno+= " / $item9"
		if(item10 !=null) retorno+= " / $item10"
		return retorno
	}

	String getItemAdd() {
		String retorno = "";
		if(itemadd1 !=null) retorno+= "$itemadd1"
		if(itemadd2 !=null) retorno+= " / $itemadd2"
		if(itemadd3 !=null) retorno+= " / $itemadd3"
		if(itemadd4 !=null) retorno+= " / $itemadd4"
		if(itemadd5 !=null) retorno+= " / $itemadd5"
		if(itemadd6 !=null) retorno+= " / $itemadd6"
		if(itemadd7 !=null) retorno+= " / $itemadd7"
		if(itemadd8 !=null) retorno+= " / $itemadd8"
		if(itemadd9 !=null) retorno+= " / $itemadd9"
		if(itemadd10 !=null) retorno+= " / $itemadd10"
		if(itemadd11 !=null) retorno+= " / $itemadd11"
		if(itemadd12 !=null) retorno+= " / $itemadd12"
		if(itemadd13 !=null) retorno+= " / $itemadd13"
		if(itemadd14 !=null) retorno+= " / $itemadd14"
		if(itemadd15 !=null) retorno+= " / $itemadd15"
		return retorno
	}

	static constraints = {
		observacao(nullable: true)
		dataAtendimento(nullable: true)
		item1(nullable: true)
		item2(nullable: true)
		item3(nullable: true)
		item4(nullable: true)
		item5(nullable: true)
		item6(nullable: true)
		item7(nullable: true)
		item8(nullable: true)
		item9(nullable: true)
		item10(nullable: true)
		itemadd1(nullable: true)
		itemadd2(nullable: true)
		itemadd3(nullable: true)
		itemadd4(nullable: true)
		itemadd5(nullable: true)
		itemadd6(nullable: true)
		itemadd7(nullable: true)
		itemadd8(nullable: true)
		itemadd9(nullable: true)
		itemadd10(nullable: true)
		itemadd11(nullable: true)
		itemadd12(nullable: true)
		itemadd13(nullable: true)
		itemadd14(nullable: true)
		itemadd15(nullable: true)
	}

	static mapping = {
		id generator:'native', params:[sequence:'pedidoid_seq']
		mesa index: 'pedido_mesa_Idx'
		estab index: 'pedido_estab_Idx'
		utilizacaoMesa index: 'pedido_utilizacaoMesa_Idx'
		usuario index: 'pedido_usuario_Idx'
		codigo index: 'pedido_codigo_Idx'
		cupomImpresso index: 'pedido_cupomImpresso_Idx'
	}
}
