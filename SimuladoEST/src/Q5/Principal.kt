package Q5

import kotlin.random.Random

fun main() {

    val robosLimpeza = Array<RoboLimpeza>(30) { RoboLimpeza(Random.nextInt(1, 18)) }
    val robosCozinha = Array<RoboCozinha>(30) { RoboCozinha(Random.nextInt(1, 20)) }

    // Se quiserem fazer nas listas separadas pode sem problemas
    // Mas eu vou juntar

    val listaNavegacao = emptyList<Navegacao>().toMutableList()
    listaNavegacao.addAll(robosLimpeza)
    listaNavegacao.addAll(robosCozinha)

    for (robo in listaNavegacao) {
        for (i in 1..<5) {
            try {
                robo.executarTarefa(Random.nextInt(1, 5))
            } catch (exception: IllegalStateException) {
                println("Sem energia, voltando pra carregar.")
                robo.retornarCarregar()
            }
        }
        robo.retornarCarregar()
    }
}