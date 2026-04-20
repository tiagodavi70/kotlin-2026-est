package pt.org.comboio.roteamento

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.response.respond
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import pt.org.comboio.Utils.DBUtils
import pt.org.comboio.linha.ParagemExposed
import pt.org.comboio.linha.ParagemServico

fun Application.configureLinha() {
    val paragemServico = ParagemServico(DBUtils.database)

    routing {
        get("/paragem") {
//            val paragem = ParagemExposed(0, "Aveiro", true)
//            paragemServico.criar(paragem)
//            println(paragem)
//            call.respond(HttpStatusCode.OK)
        }
    }
}