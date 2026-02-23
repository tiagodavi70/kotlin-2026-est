
fun main() {

    val idade:Int = 17

    if (idade >= 18) {
        println("Pode votar.")
    } else {
        println("Não pode votar.")
    }

    val nome = ""
    when (nome) {
        "Tiago" -> print("Tiago")
        "Manoel" -> print("Não é o Tiago")
        else -> {
            println("Não é ninguém conhecido.")
            println("Chavetas necessárias.")
        }
    }

    val numeroA = 8
    val nomeB = "Tiago"
    when {
        numeroA % 2 == 0 -> print("$numeroA é par")
        nomeB != "Manoel" -> print("Diferentes")
    }
}