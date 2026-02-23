package solucoes

fun main() {

    print("Entra com um número de 3 dígitos: ")
    val cdu:Int = readln().toInt() // 321

    val c:Int = cdu / 100 // 3
    val d:Int = (cdu - c*100) / 10 // 2
    val u:Int = cdu - c*100 - d*10 // 1

    val udc:Int = u*100 + d*10 + c
    println(udc)
}