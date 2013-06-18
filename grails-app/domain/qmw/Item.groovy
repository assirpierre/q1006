package qmw

class Item {

	String descricao
	String tipo
    boolean aprovado
	static hasMany = [adicionais: Adicionais, menuPrincipal: MenuPrincipal, menu:Menu]
	
	String toString () {
		"${descricao}"
	}
	
	static constraints = {
		descricao(blank:false, unique:true, size: 3..22)
		tipo(nullable:false,inList: ["Menu","Produto"])
	}
}
