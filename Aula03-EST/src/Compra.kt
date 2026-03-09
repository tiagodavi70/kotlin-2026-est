
class Compra(val cliente: Cliente, val automovel: Automovel, val data: String = "01/01/2026") {

    init {
        automovel.venda(cliente)
        // automovel.proprietario = cliente
    }
}
