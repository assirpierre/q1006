package qmw

import java.util.Date;

class UtilizacaoMesa {

	String nome
	Date dataInicio
	Date dataFim
	double subTotal
	double servico
	double total
	boolean cupomImpresso
	static belongsTo = [estab: Estabelecimento, mesa: Mesa]
	
	static constraints = {
		nome(nullable: true)
		dataFim(nullable: true)
		subTotal(nullable: true)
		servico(nullable: true)
		total(nullable: true)
	}
	static mapping = {
		id generator:'native', params:[sequence:'utilizacao_mesaid_seq']
		estab index: 'utilizacaoMesa_estab_Idx'
	}
}
