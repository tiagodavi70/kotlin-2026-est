
// class Pessoa(val nome: String, val idade: Int)

//class Pessoa(nome: String, idade: Int) {
//    val nome: String = nome.trim()
//    val idade: Int = idade
//}

/*
class Pessoa(nome: String, idade: Int) {
    val nome: String
    val idade: Int

    init {
        require(nome.isNotBlank()) { "Nome não pode ser vazio." }
        require(idade >= 0 ) { "Idade não pode ser negativa." }

        this.nome = nome.trim()
        this.idade = idade
    }
} */

class Pessoa(val nome: String, val idade: Int) {

    constructor(nome: String): this(nome, 18)
    constructor(pessoa: Pessoa): this(pessoa.nome, pessoa.idade)

}
