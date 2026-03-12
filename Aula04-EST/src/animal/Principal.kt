package animal
fun main() {
    // val animal1 = animal.Animal("animal")
    val gato1 = Gato("gato")
    val cao1 = Cao("cachorro", 2026)

    //println(animal1)
    //println(animal1.barulho())

    println(gato1)
    println(gato1.barulho())

    println(cao1)
    println(cao1.anoNascimento)
    println(cao1.barulho())
}