
fun main() {

    val lista1 = listOf(1, 2, 3)
    val lista2 = List(0) { 0 }

    println(lista1)
    println(lista2)

    val lista3 = mutableListOf(1, 2, 3)
    lista3.add(4)
    println(lista3)

    println(lista3.indexOf(3))
    lista3.removeAt(2)
    lista3.addFirst(10)
    val lista4 = lista3.asReversed() // reverse() (in place)
    println(lista4)
    println(lista3.sum())
    println(lista3.average())
    println(lista3.max())
    lista3.add(5)
    lista3.add(6)
    lista3.add(7)
    println(lista3)
    println(lista3.slice(2..4))

    println(lista3.toIntArray())
    val vetor = arrayOf(1,2,3,4)
    println(vetor.toList())

    val conjunto1 = setOf(1,2,3,3,4,5)
    println(conjunto1)

    val conjunto2 = mutableSetOf(1,2,3,3,4,5)
    println(conjunto2)
    conjunto2.add(6)

    val dicionario1 = mapOf("primeiro" to 1, "segundo" to 2)
    val dicionario2 = mapOf(1.0 to "primeiro", 2.0 to "segundo")
    val dicionario3 = emptyMap<String, Int>()
    val dicionario4 = emptyMap<Any, Any>() // tudo de ruim vai acontecer
    val dicionario5 = mutableMapOf("primeiro" to 3, "segundo" to 4)

    
    println(dicionario5)

}