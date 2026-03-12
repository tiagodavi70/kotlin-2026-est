package animal

class Cao(nome: String, val anoNascimento: Int): Animal(nome) {

    override fun barulho(): String {
        return "au au"
    }

}