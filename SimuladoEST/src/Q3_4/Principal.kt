package Q3_4

fun main() {

    val conta1 = ContaBancaria("a", 10.0)
    val conta2 = ContaBancaria("b", 10.0)
    val conta3 = ContaBancaria("c", 10.0)
    val conta4 = ContaBancaria("d", 10.0)
    val conta5 = ContaBancaria("e", 10.0)

    val contas = listOf<ContaBancaria>(conta1, conta2, conta3, conta4, conta5)

    try {
        conta1.retirada(20.0)
    } catch (exception: SaldoInsuficienteException) {
        println("Saldo insuficiente.")
    }

    print("Entra com o código: ")
    val codigo: String = readln()
    print("Operação: (D - deposito | R - retirada")
    val operacao: String = readln()
    print("Entra com o valor: ")
    val valor: Double = readln().toDouble()

    var encontrouConta: Boolean = false
    var contaFinal = contas[0]
    for (conta in contas) {
        if (codigo == conta.id) {
            contaFinal = conta
            encontrouConta = true
        }
    }

    if (encontrouConta) {
        if (operacao == "D") {
            contaFinal.deposito(valor)
        } else if (operacao == "R") {
            contaFinal.retirada(valor)
        }
        println(contaFinal.saldo())
    } else {
        println("Não encontrei conta")
    }
}