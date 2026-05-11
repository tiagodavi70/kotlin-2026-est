package pt.org.comboio.pessoa

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import pt.org.comboio.Utils.DBUtils.dbQuery

@Serializable
data class UtilizadorExposed(val nome: String, val nif: String) {
//    init {
//        require(nif.length == 9) { "Erro" }
//    }
}

class UtilizadorServico(database: Database) {
    object Utilizador: Table() {
        val id = integer("id").autoIncrement()
        val nome = varchar("nome", 50)
        val nif = varchar("nif", 9)
    }

    init {
        transaction {
            SchemaUtils.create(Utilizador)
        }
    }

    suspend fun criar(utilizador: UtilizadorExposed) {
        dbQuery {
            Utilizador.insert {
                it[nome] = utilizador.nome
                it[nif] = utilizador.nif
            }
        }
    }

    suspend fun ler(): List<UtilizadorExposed> {
        return dbQuery {
            Utilizador.selectAll()
                .map { UtilizadorExposed(it[Utilizador.nome], it[Utilizador.nif]) }
        }
    }
}