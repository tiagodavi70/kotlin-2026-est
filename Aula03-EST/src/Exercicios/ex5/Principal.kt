package Exercicios.ex5

fun main() {

    val pedido = Pedido("Tiago")
    val item1 = Item("a", 12.0)
    val item2 = Item("b", 13.0)
    val item3 = Item("c", 15.0)
    val item4 = Item("d", 16.0)

    // Corrigir
    pedido.lista.add(item1)
    pedido.lista.add(item2)
    pedido.lista.add(item3)
    pedido.lista.add(item4)

    println(pedido.valorTotal())
}