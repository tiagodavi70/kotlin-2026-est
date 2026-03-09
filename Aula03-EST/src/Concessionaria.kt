
fun main() {

    val cliente1 = Cliente("Tiago", "888999777")
    val cliente2 = Cliente("Manoel", "777777777")

    val automovel1 = Automovel("a", 2021, 15000.00)
    val automovel2 = Automovel("b", 2022, 16000.00)

    val compra1 = Compra(cliente1, automovel1)
    val compra2 = Compra(cliente2, automovel2, "02/03/2026")

    println(compra2.automovel.proprietario?.nome)

    // nome vazio | nif vazio tamanho | automovel modelo preço > 0 ano > 1950
    // restringir o dono
}