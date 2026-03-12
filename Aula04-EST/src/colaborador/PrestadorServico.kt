package colaborador

class PrestadorServico(val nome: String, val valorSemana: Double): Pagamento {
    override val iban: String = ""

    override fun pagamentoMensal(): Double {
        return valorSemana * 4
    }
    override fun pagamentoHora(): Double {
        return valorSemana / 40
    }
}