package qmw

class Menu {

	String descricaoestab
	double preco
	int sequencia
	static belongsTo = [estab: Estabelecimento, grupoAdicionais: GrupoAdicionais, menuPrincipal: MenuPrincipal, item: Item]

	String toString () {
		"${item}"
	}

	static constraints = {
		menuPrincipal(blank:false)
		item(blank: false, unique: ['estab','menuPrincipal'])
		descricaoestab(maxSize: 300)
		preco(blank: false, matches: /\d+/)
		grupoAdicionais(nullable: true)
	}
	static mapping = {
		estab index: 'menu_estab_Idx'
		menuPrincipal index: 'menu_menuPrincipal_Idx'
	}
}
