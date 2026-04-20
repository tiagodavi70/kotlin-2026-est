package pt.org.comboio.linha

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.transactions.transaction
import pt.org.UserService.Users
import pt.org.comboio.Utils.DBUtils

@Serializable
data class ParagemExposed(
    val id:Int,
    val nome:String,
    val estacao: Boolean = true
)

//CREATE TABLE PARAGEM(
//    id INTEGER autoincrement PRIMARY KEY,
//    nome VARCHAR(50),
//    estacao BOOL,
//
//    CONSTRAINT PRIMARY KEY id
//);

class ParagemServico(database: Database) {

    object Paragem: Table() {
        val id = integer("id").autoIncrement()
        val nome = varchar("nome", 50)
        val estacao = bool("estacao")

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction(database) {
            SchemaUtils.create(Paragem)
        }
    }

    // entrada
    suspend fun criar(paragem: ParagemExposed) {
        DBUtils.dbQuery {
            Paragem.insert {
                it[nome] = paragem.nome
                it[estacao] = paragem.estacao
            }
        }
    }


    // saida

}