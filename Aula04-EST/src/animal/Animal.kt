package animal

abstract class Animal(val nome: String) {

    abstract fun barulho() : String

    override fun toString() : String {
        return "Meu nome é $nome. " + super.toString()
    }
}