package colaborador

fun main() {

    val colaborador1 = Colaborador("a", 5.9)
    val colaborador2 = Colaborador("b", 6.5, "Patrão")
    val prestador1 = PrestadorServico("c", 6.5 * 40)

    // colaborador1.valorHora = 10000.00 // absurdo não pode acontecer
    println(colaborador1.valorHora)
    // colaborador1.valorHora = 100.0
    colaborador1.setValorHora(6.0, colaborador2)
    println(colaborador1.valorHora)
    // colaborador1._valorHora

    val pagaveis = listOf<Pagamento>(colaborador1, colaborador2, prestador1)
    for (pagavel in pagaveis) {
        println("Pagar: ${pagavel.pagamentoMensal()}")
        pagavel.iban
    }
}