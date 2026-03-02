
// assinatura
// nome parametros? retorno? conteudo?

// camelcase - olaMundo - underline - ola_mundo
fun olaMundo(nome: String) {
    println("Olá $nome")
}

fun soma(numero1: Number, numero2: Number): Number {
    val soma = numero1.toDouble() + numero2.toDouble()
    return soma as Number
}

fun soma(numero1: Double, numero2: Double): Double {
    val soma = numero1 + numero2
    return soma
}

fun main() {
    olaMundo("Tiago")
    println(soma(1.0, 2.0))
}