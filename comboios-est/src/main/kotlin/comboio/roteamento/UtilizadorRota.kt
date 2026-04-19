package pt.org.comboio.roteamento

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.param
import io.ktor.server.routing.post
import io.ktor.server.routing.put
import io.ktor.server.routing.routing
import pt.org.comboio.pessoa.Utilizador

fun Application.configureUtilizadorAula() {
    val utilizadores = listOf<Utilizador>(
        Utilizador("Tiago", "989898989"),
        Utilizador("Davi", "989898989"),
        Utilizador("Alexandre", "989898989")
    )

    routing {
        // http://127.0.0.1:8080/utilizador-query?nome="Tiago"&nif="999999999"
        get("/utilizador-query") {
            val parameters = call.queryParameters
            val nome: String? = parameters.get("nome")
            val nif: String? = parameters["nif"]

            if (nome != null && nif != null) {
                val utilizador = Utilizador(nome, nif)
                call.respondText(utilizador.toString())
            } else {
                call.respond(HttpStatusCode.BadRequest, "")
            }
        }

        post("/utilizador-post") {
            val parametros = call.receiveParameters()
            val nome: String? = parametros["nome"]
            val nif: String? = parametros["nif"]

            if (nome != null && nif != null) {
                val utilizador = Utilizador(nome, nif)
                println(utilizador)
                call.respond(HttpStatusCode.Created, nome)
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        // http://127.0.0.1/utilizador/1
        get("utilizador/{indice}") {
            val parametros = call.parameters
            val indice: Int? = parametros["indice"]?.toIntOrNull()

            if (indice != null && indice >= 0 && indice < utilizadores.size) { // indice in 0..<utilizadores.size
                val utilizador = utilizadores[indice]
                call.respondText(utilizador.toString())
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        get("utilizador/") {
            //call.respond(utilizadores.toString())
            call.respond(utilizadores)
        }
    }
}

fun Application.configureUtilizador() {
    val utilizadores = mutableListOf<Utilizador>(
        Utilizador("Tiago", "989898989"),
        Utilizador("Davi", "989898989"),
        Utilizador("Alexandre", "989898989")
    )

    routing {
        post("/utilizador") {
            val parametros = call.receiveParameters()
            val nome: String? = parametros["nome"]
            val nif: String? = parametros["nif"]

            if (nome != null && nif != null) {
                val utilizador = Utilizador(nome, nif)
                utilizadores.add(utilizador)
                call.respond(HttpStatusCode.Created, nome)
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        // http://127.0.0.1/utilizador/1
        get("utilizador/{indice}") {
            val parametros = call.parameters
            val indice: Int? = parametros["indice"]?.toIntOrNull()

            if (indice != null && indice >= 0 && indice < utilizadores.size) { // indice in 0..<utilizadores.size
                val utilizador = utilizadores[indice]
                call.respondText(utilizador.toString())
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
        get("utilizador/") {
            //call.respond(utilizadores.toString())
            call.respond(utilizadores)
        }
        delete("utilizador/{indice}") {
            val indice: Int? = call.parameters["indice"]?.toIntOrNull()
            if (indice != null && indice in 0..<utilizadores.size) {
                utilizadores.remove(utilizadores[indice])
                call.respond(HttpStatusCode.OK)
            } else call.respond(HttpStatusCode.BadRequest)
        }

        put("utilizador/{indice}") {
            val parametros = call.receiveParameters()
            val nome: String? = parametros["nome"]
            val nif: String? = parametros["nif"]

            val indice: Int? = call.parameters["indice"]?.toIntOrNull()

            if (nome != null && nif != null && indice != null && indice in 0..<utilizadores.size) {
                val utilizador = Utilizador(nome, nif)
                utilizadores[indice] = utilizador
                call.respond(HttpStatusCode.Created, nome)
            } else {
                call.respond(HttpStatusCode.BadRequest)
            }
        }
    }
}