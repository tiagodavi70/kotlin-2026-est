package solucoes

fun main() {

    print("Entra com o nome do time 1: ")
    val time1: String = readln()
    print("Entra com o número de gols: ")
    val gols1: Int = readln().toInt()

    print("Entra com o nome do time 2: ")
    val time2: String = readln()
    print("Entra com o número de gols: ")
    val gols2: Int = readln().toInt()

    if (gols1 > gols2) {
        println("$time1 venceu")
    } else if ( gols2 > gols1) {
        println("$time2 venceu")
    } else {
        println("Empate")
    }
    when {
        gols1 > gols2 -> println("$time1 venceu")
        gols2 > gols1 -> println("$time2 venceu")
        else -> println("Empate")
    }
}