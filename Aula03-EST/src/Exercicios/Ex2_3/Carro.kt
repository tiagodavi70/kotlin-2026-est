package Exercicios.Ex2_3

class Carro(val marca: String, val modelo: String, val velocidade: Double, val ano: Int) {

    fun idade():Int {
        return java.time.LocalDate.now().year - this.ano
    }

    val idade: Int
        get() = java.time.LocalDate.now().year - this.ano

    fun exibir() {
        println("$marca $modelo $velocidade $ano")
    }

    fun milhas(): Double {
        return this.velocidade * 0.62137
    }

    //fun milhas():Double = this.velocidade * 0.62137

    val milhas: Double
        get() = this.velocidade * 0.62137
}

fun main() {
    val carro1 = Carro("a", "b", 120.0, 2021)
    carro1.exibir()
    println(carro1.idade())
    println(carro1.idade)
}


