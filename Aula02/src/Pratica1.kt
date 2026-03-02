
// Criar um algoritmo que armazene nome e duas notas de 5 alunos
// e imprima uma listagem contendo nome, as duas notas e a média de
// cada aluno.

fun main() {

    val nomes = Array(5) { "" }
    val nota1 = Array(5) { 0.0 }
    val nota2 = Array(5) { 0.0 }

    for (i in 0..<nomes.size) {
        println("Aluno ${i + 1}")
        print("Entra com o nome: ")
        nomes[i] = readln()
        print("Entra com a nota 1: ")
        nota1[i] = readln().toDouble()
        print("Entra com a nota 2: ")
        nota2[i] = readln().toDouble()
    }

    for (i in 0..<nomes.size) {
        val media = (nota1[i] + nota2[i]) / 2
        println("${nomes[i]} ${nota1[i]} ${nota2[i]} $media")
    }
}