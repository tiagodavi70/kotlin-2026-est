package ex1

import kotlin.random.Random

fun main() {

    val felinos = emptyList<Felino>().toMutableList()
    for (i in 0..40) {
        when (Random.nextInt(1,3)) {
            1 -> felinos.add(Gato("aaa", 3.0))
            2 -> felinos.add(Leao("bbb", 300.0))
            3 -> felinos.add(Tigre("ccc", 250.0))
            else -> {}
        }
    }
    println(felinos)
}