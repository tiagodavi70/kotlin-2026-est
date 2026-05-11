package pt.org.comboio.roteamento

import io.ktor.server.application.Application
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondRedirect
import io.ktor.server.routing.get
import io.ktor.server.routing.post
import io.ktor.server.routing.routing
import io.ktor.server.thymeleaf.ThymeleafContent
import pt.org.comboio.Utils.DBUtils
import pt.org.comboio.pessoa.UtilizadorExposed
import pt.org.comboio.pessoa.UtilizadorServico
import kotlin.collections.mapOf

fun Application.configurePessoa() {

    val utilizadorExposed = UtilizadorExposed("Tiago", "99999999")
    val utilizadorExposed2 = UtilizadorExposed("Davi", "8888888")

    // val utilizadores = listOf<UtilizadorExposed>(utilizadorExposed, utilizadorExposed2, utilizadorExposed)

    val utilizadorServico = UtilizadorServico(DBUtils.database)

    routing {
        get("/utilizador.html") {
            call.respond(ThymeleafContent("utilizador",
                mapOf("utilizador" to utilizadorExposed, "utilizador2" to utilizadorExposed2)))
        }

        get("/utilizadores.html") {
            val utilizadores = utilizadorServico.ler()
            call.respond(ThymeleafContent("utilizadores", mapOf("lista" to utilizadores)))
        }

        post("/utilizador") {
            val params = call.receiveParameters()
            val nome: String? = params["nome"]
            val nif: String? = params["nif"]
            if (nome != null && nif != null && nome != "" && nif != "") {
                val novoUtilizador = UtilizadorExposed(nome, nif)
                utilizadorServico.criar(novoUtilizador)
                call.respondRedirect("index.html") // página de acerto
            } else {
                call.respondRedirect("utilizador.html") // página de erro
            }
        }
    }
}