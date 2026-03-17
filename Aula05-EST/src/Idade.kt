

fun main() {

    print("Entra com a idade: ")
    // val idade: Int = readln().toInt()
    var idade = 0
    try {
        idade = readln().toInt()
        require(idade >= 0) // { "Idade deve ser um número positivo" }
    } catch (exception: NumberFormatException) {
        idade = 0
        println("Idade inválida. Digite um número.")
    } catch (exception: IllegalArgumentException) {
        idade = 0
        println("Idade deve ser um número positivo")
    } finally {
        println(idade)
    }

}