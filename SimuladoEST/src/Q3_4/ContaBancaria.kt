package Q3_4

class ContaBancaria(val id: String, saldo: Double) {
    private var saldo: Double = saldo

    fun saldo(): Double {
        return saldo
    }

    init {
        require(saldo > 0) { "Saldo deve ser positivo." }
    }

    fun retirada(valor: Double) {
        require(valor > 0.0) { "Valor deve ser positivo" }
        // check(saldo - valor >= 0.0) { "Saldo insuficiente" }
        if (saldo - valor <= 0.0) {
            throw SaldoInsuficienteException("Saldo insuficiente")
        }
        saldo = saldo - valor
    }

    fun deposito(valor: Double) {
        require(valor > 0.0) { "Valor deve ser positivo" }
        saldo += valor
    }
}

class SaldoInsuficienteException(mensagem: String): Exception(mensagem)