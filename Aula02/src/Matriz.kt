import kotlin.random.Random

fun main() {

    val matriz = Array(4) { Array(4) { Random.nextInt(0, 100) } }
    for (i in 0..<matriz.size) {
        for (j in 0..<matriz[i].size) {
            print("${matriz[i][j]} ")
        }
        println()
    }
}