package pt.org.comboio.roteamento

import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import io.ktor.server.thymeleaf.ThymeleafContent
import pt.org.comboio.pessoa.Utilizador
import kotlin.collections.mapOf

fun Application.configurePessoa() {

    val utilizador = Utilizador("Tiago", "99999999")
    val utilizador2 = Utilizador("Davi", "8888888")

    val utilizadores = listOf<Utilizador>(utilizador, utilizador2, utilizador)

    routing {
        get("/utilizador.html") {
            call.respond(ThymeleafContent("utilizador",
                mapOf("utilizador" to utilizador, "utilizador2" to utilizador2)))
        }

        get("/utilizadores.html") {
            call.respond(ThymeleafContent("utilizadores", mapOf("lista" to utilizadores)))
        }
    }
}