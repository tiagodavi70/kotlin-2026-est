package ex1

class Leao(nome: String, peso: Double): Felino(nome, peso) {
    override fun domestico() = false
}