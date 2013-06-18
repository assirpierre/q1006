package qmw

class LogAcesso {

	int dispositivo
	String metodo
	int qtde

    static constraints = {
    }

	static mapping = {
		id generator:'native', params:[sequence:'log_acessoid_seq']		
		metodo index: 'logAcesso_metodo_Idx'
	}		
}
