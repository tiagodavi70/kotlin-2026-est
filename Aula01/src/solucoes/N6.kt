package solucoes

fun main() {

    // && and
    // || or
    // ~ not

    var contador:Int = 0
    var entrada:String = ""
    while (entrada != "q") {
        print("Entra com um número (q para encerrar): ")
        entrada = readln()
        if (entrada != "q") {
            val num:Int = entrada.toInt()
            if ((num >= 50) && (num <= 150)) {
                contador = contador + 1
            }
        }
    }
    print(contador)
}