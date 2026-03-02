fun main() {

    val nomes = Array(5) { "" }

    for (i in 0..<nomes.size) {
        print("Entra com o nome: ")
        nomes[i] = readln()
    }
    println()
    // busca
    print("Entra com o nome para buscar: ")
    val novoNome:String = readln()
    var posicao:Int = -1
    for (i in 0..<nomes.size) {
        if (nomes[i] == novoNome) {
            posicao = i
        }
    }
    val novaPosicao = nomes.indexOf(novoNome)
    println(novaPosicao)
    if (posicao >= 0) {
        println("Encontrado na posição: $posicao.")
    } else {
        println("Não encontrado.")
    }

}