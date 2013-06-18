package qmw

class LogDispositivo {

	int dispositivo
	Date data
	String dados
	static belongsTo = [estab: Estabelecimento]
	
    static constraints = {
    }
	static mapping = {
		dados type: 'text'
		id generator:'native', params:[sequence:'log_dispositivoid_seq']
	}

}
