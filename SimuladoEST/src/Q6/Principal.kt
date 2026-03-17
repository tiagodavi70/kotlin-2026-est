package Q6

fun main() {

    val filme1 = FilmeDigital("a", "b", 10.0, 90)
    val filme2 = FilmeDigital("aa", "bb", 12.0, 100)
    val filme3 = FilmeDigital("aa", "bb", 13.0, 110)

    val livro1 = LivroDigital("a", "b", 10.0, 100)
    val livro2 = LivroDigital("a", "b", 15.0, 110)
    val livro3 = LivroDigital("a", "b", 20.0, 120)

    val musica1 = MusicaDigital("a", "b", 10.0, "c")
    val musica2 = MusicaDigital("a", "b", 12.0, "cc")
    val musica3 = MusicaDigital("a", "b", 13.0, "ccc")

    val listaMidias = mutableListOf<Midia>(filme1, filme2, filme3, livro1, livro2, livro3, musica1, musica2, musica3)

    print("Entra com o titulo: ")
    val titulo:String = readln()
    print("Entra com o genero: ")
    val genero:String = readln()
    print("Entra com o preco: ")
    val preco:Double = readln().toDouble()
    print("Entra com o número de páginas: ")
    val paginas:Int = readln().toInt()

    val livro4 = LivroDigital(titulo, genero, preco, paginas)
    listaMidias.add(livro4)
    val menorPreco: Midia = menorPrecoIndicarMedia(listaMidias)
    println("${menorPreco.titulo} ${menorPreco.preco}")

    val listaLivros = listOf<LivroDigital>(livro1, livro2, livro3, livro4)
    // listaMidias.filter { it is LivroDigital }
    maiorPaginas(listaLivros)
}

fun menorPrecoIndicarMedia(lista: List<Midia>): Midia {
    var menorPrecoMidia: Midia = lista[0]
    for (midia in lista) {
        if (menorPrecoMidia.preco > midia.preco) {
            menorPrecoMidia = midia
        }
    }

    var soma = 0.0
    for (midia in lista) {
        soma += midia.preco
    }
    println("Media: ${soma/lista.size}")
    return menorPrecoMidia
}

fun maiorPaginas(lista: List<LivroDigital>): LivroDigital {
    var maiorPaginas: LivroDigital = lista[0]

    for (livro in lista) {
        if (maiorPaginas.numPaginas < livro.numPaginas) {
            maiorPaginas = livro
        }
    }
    return maiorPaginas
}

