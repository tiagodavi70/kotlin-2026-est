
class Conta(private var _valor: Double) {
    init {
        //require(valor > 0)
        if (_valor < 0.0) {
            _valor = 0.0
            throw SaldoNegativoException("Saldo não pode ser negativo.")
        }
    }
    var valor: Double
        get() = _valor
        set(value) {
            if (_valor < 0.0) {
                throw SaldoNegativoException("Saldo não pode ser negativo.")
            }
        }
}

class SaldoNegativoException(mensagem: String): Exception(mensagem)

fun main() {
    val conta1: Conta = Conta(10.0)
    try {
        conta1.valor = -10.0
    } catch(exception: SaldoNegativoException) {
        println(exception.message)
    } finally {
        println(conta1.valor)
    }
}