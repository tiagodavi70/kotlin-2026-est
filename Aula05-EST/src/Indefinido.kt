
fun main() {
    // print(0/0)
    val a: Int = 1
    val b: Int = 0

    if (b != 0) {
        print(a/b)
    } else {
        println("IF - Não posso dividir por 0.")
    }

    try {
        print(a/b)
    } catch(e: ArithmeticException) {
        println("Não posso dividir por 0.")
    }
}