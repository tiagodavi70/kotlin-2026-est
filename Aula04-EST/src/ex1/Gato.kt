package ex1

class Gato(nome: String, peso: Double): Felino(nome, peso) {
    override fun domestico(): Boolean {
        return true
    }
}