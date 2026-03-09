package Exercicios.ex5

class Pedido(val nomeCliente: String, val dia: String = "01/01/2026") {
    val lista: MutableList<Item> = emptyList<Item>().toMutableList()

    constructor(nomeCliente: String, dia: String, lista: MutableList<Item>)
            : this(nomeCliente, dia) {
        this.lista.addAll(0, lista)
    }

    fun valorTotal(): Double {
        var soma:Double = 0.0
        for (item in this.lista) {
            soma += item.preco
        }
        return soma
    }
}