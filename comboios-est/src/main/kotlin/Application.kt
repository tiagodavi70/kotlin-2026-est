package pt.org

import io.ktor.server.application.*
import pt.org.comboio.roteamento.configurePessoa
import pt.org.comboio.roteamento.configureUtilizador
import pt.transporte.comboio.roteamento.configureLinha

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {

    configureHTTP()
    configureTemplating()
    configureSerialization()
    configureDatabases()
    configureRouting()

    //configureUtilizador()
    configurePessoa()
    configureLinha()
}
