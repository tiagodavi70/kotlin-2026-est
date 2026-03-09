package Exercicios.ex5

class Item(val nome: String, val preco: Double, val imposto: Double = 0.23) {
    fun calcularImposto():Double {
        return this.preco + this.preco * this.imposto
    }
}

