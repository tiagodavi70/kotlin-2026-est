
// Crie um algoritmo que armazene 5 números em um vetor.
// Imprima uma listagem.

fun main() {
    val vetor1 = Array(5) { 0 } // vetor de inteiros Array<Int>
    val vetor2 = Array(10) { 0.0 } // vetor de double Array<Double>

    // for ( i in 0..<vetor1.size)
    for (i in 0..vetor1.size - 1) { // len(lista) lista.length lista.Length
        print("Entra com o valor ${i + 1}: ")
        vetor1[i] = readln().toInt()
    }
    println(vetor1)
    for (i in 0..<vetor1.size) {
        print("${vetor1[i]} ")
    }

    val vetorPronto = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
    val vetorPronto2 = intArrayOf(1, 2, 3, 4, 5)

    for (item in vetorPronto) {
        print("$item ")
    }
}