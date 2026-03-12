package colaborador

interface Pagamento {
    val iban: String
    fun pagamentoMensal(): Double
    fun pagamentoHora(): Double {
        return 5.75
    }
}