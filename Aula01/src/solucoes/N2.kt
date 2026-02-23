package solucoes

// 920€

fun main() {

    print("Entra com o valor do salário mínimo: ")
    val salarioMinimo: Double = readln().toDouble()

    print("Entra com o salário do colaborador:")
    val salarioColaborador:Double = readln().toDouble()

    println("O colaborador recebe: ${salarioColaborador / salarioMinimo} salários" +
            " mínimos")
}