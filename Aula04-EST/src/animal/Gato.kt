package animal
class Gato(nome: String): Animal(nome) {

    override fun barulho(): String {
        return "miau miau"
    }
}