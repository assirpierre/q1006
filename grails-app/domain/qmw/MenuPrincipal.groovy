package qmw

class MenuPrincipal {

	String tipoCobranca
	String localAtendimento
	int qtdeitem
	int sequencia
	boolean imprimeCupom
	
	static belongsTo = [estab: Estabelecimento, item: Item]
	static hasMany = [menu:Menu, pedido:Pedido]

	String toString () {
		"${item}"
	}

	static constraints = {
		item(blank:false, unique: 'estab')
		qtdeitem(blank:false, min:1)
		sequencia(blank:false)
		tipoCobranca(blank:false, inList: ["Normal","Media"])
		localAtendimento(blank:false, inList: ["1","2","3","4"])
	}
	static mapping = {
		sort "sequencia"
		estab index: 'menuPrincipal_estab_Idx'
	}

}
