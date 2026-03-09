class Automovel(modelo: String, val ano: Int, val preco: Double) {

    val modelo: String = modelo.trim()
    var proprietario: Cliente? = null

    init {
        require(this.modelo.isNotBlank()) { "Modelo não pode ser vazio." }
        require(this.preco > 0) { "Preço não pode ser negativo." }
        require(this.ano > 1950) { "Ano tem que ser maior que 1950." }
        require(this.ano.toString().length == 4) { "Ano tem que ter 4 digítos" }
    }

    fun venda(cliente: Cliente) {
        this.proprietario = cliente
    }
}

