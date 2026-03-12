package animal
class Passaro(nome: String): Animal(nome) {

    override fun barulho(): String {
        return "piu piu"
    }
}