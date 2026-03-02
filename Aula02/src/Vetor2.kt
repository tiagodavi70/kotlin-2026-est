
fun main() {

    val vetor1 = Array(5) { 0 }
    val vetor2 = Array(5) { 0 }

    for (i in 0..<vetor1.size) {
        print("Entra com o valor ${i + 1}: ")
        vetor1[i] = readln().toInt()
    }
    for (i in 0..<vetor2.size) {
        print("Entra com o valor ${i + 1}: ")
        vetor2[i] = readln().toInt()
    }

    val soma = Array(5) { 0 }
    for (i in 0..<vetor1.size) {
        soma[i] = vetor1[i] + vetor2[i]
    }
    for (item in soma) {
        print("$item ")
    }

    // val nome = Array(5) { "" }
}