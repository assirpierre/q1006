package qmw

class Adicionais {

	String descricaoestab
	double preco
	static belongsTo = [estab: Estabelecimento, grupoAdicionais: GrupoAdicionais, item: Item]
	
	String toString () {
		"${item} - ${descricaoestab}"
	}
	
    static constraints = {
		grupoAdicionais(blank:false)
		item(blank: false, unique: ['estab','grupoAdicionais'])
		descricaoestab(maxSize: 300)
		preco(blank: false, matches: /\d+/)
		estab(display: false)
    }
	static mapping = {
		estab index: 'adicionais_estab_Idx'
	}
}
