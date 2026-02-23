
fun main() {

    for (i in 1..10) {
        println(i)
    }
    println()
    for (i in 1..10 step 2) {
        println(i)
    }
    println()
    for (i in 10 downTo 1) {
        println(i)
    }
    println()

    val a = arrayOf(1,2,3)
    for (i in 0..< a.size) {
        println(a[i])
    }
    println()
    for (i in 1..< 10) {
        println(i)
    }

    for (i in 1..10) {
        println(i)
    }

    var i = 0
    while (i < 10) {
        println(i)
        i = i + 1 // i += 1  i++
    }
}