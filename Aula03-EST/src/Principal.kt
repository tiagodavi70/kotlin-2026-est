
fun main() {

    val pessoa1 = Pessoa(" Tiago ", 33)
    val pessoa2 = Pessoa("Manoel", 32)
    val pessoa3 = Pessoa("Alexandre", 0)
    val pessoa4 = Pessoa("Izabella")
    val pessoa5 = Pessoa(pessoa1)

    println("${pessoa1.nome} ${pessoa1.idade}")
    println(pessoa2.nome)
    println(pessoa3.idade)
    println("${pessoa4.nome} ${pessoa4.idade}")
    println("${pessoa5.nome} ${pessoa5.idade}")
}