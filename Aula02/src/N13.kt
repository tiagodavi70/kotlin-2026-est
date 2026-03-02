import kotlin.random.Random

// Escreva uma função que dado um valor n crie um vetor
// com n posições aleatórias.

fun main() {

    print("Entra com o tamanho do vetor: ")
    val tamanho: Int = readln().toInt()
    val vetor = Array(tamanho) { 0 }

    for (i in 0..<vetor.size) {
        vetor[i] = Random.nextInt(0, 100)
    }
    for (item in vetor) {
        print("$item ")
    }
}