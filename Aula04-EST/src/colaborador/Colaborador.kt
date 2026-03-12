package colaborador

class Colaborador(val nome: String,
                  valorHora: Double,
                  cargo: String = "Não Patrão"): Pagamento {

    override val iban: String = ""
    val historicoCargos = emptyList<String>().toMutableList()
    var cargo: String = cargo
        get() {
            return field
        }
        set(value) {
            historicoCargos.add(value)
            field = value
        }

    private var _valorHora: Double = valorHora

    val valorHora: Double
        get() {
            return _valorHora
        }

    fun setValorHora(valorNovo: Double, patrao: Colaborador) {
        if (patrao.cargo == "Patrão") {
            _valorHora = valorNovo
        } else {
            println("Precisa ser patrão para aprovar essa mudança.")
        }
    }

    init {
        require(_valorHora >= 5.75) { "Não tenha escravos" }
        require(cargo in listOf("Patrão", "Não Patrão")) { "Permitido somente: Patrão e Não Patrão" }
    }

    override fun pagamentoMensal(): Double {
        return valorHora * 40 * 4
    }

    // override fun pagamentoHora() = valorHora
    override fun pagamentoHora() : Double {
        return valorHora
    }

    override fun toString(): String {
        return "$nome | $valorHora"
    }
}