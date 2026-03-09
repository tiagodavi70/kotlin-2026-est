class Cliente(nome: String, nif: String) {

    val nome:String = nome.trim()
    val nif:String = nif.trim()

    init {
        require(nome.isNotBlank()) { "Nome não pode ser vazio" }
        require(nif.isNotBlank() && nif.length == 9) { "NIF errado." }
    }

}