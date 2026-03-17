package Q5

class RoboLimpeza(var energia: Int): Navegacao {

    private val energiaMaxima: Int = 18

    override fun executarTarefa(energiaUtilizada: Int) {
        require(energiaUtilizada >= 1 && energiaUtilizada <= 5) { "Consumo incorreto" }
        check(energia - energiaUtilizada < 0) { "Sem energia." }
        energia -= energiaUtilizada
    }

    override fun retornarCarregar() {
        energia = energiaMaxima
    }
}