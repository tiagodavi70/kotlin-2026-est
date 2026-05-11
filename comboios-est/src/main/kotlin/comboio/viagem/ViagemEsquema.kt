package pt.transporte.comboio.viagem

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import pt.transporte.comboio.comboio.ComboioExposed
import pt.transporte.comboio.comboio.ComboioServico
import pt.transporte.comboio.linha.LinhaExposed
import pt.transporte.comboio.linha.LinhaServico
import pt.transporte.comboio.pessoa.PessoaExposed
import pt.transporte.comboio.pessoa.PessoaServico
import pt.transporte.comboio.pessoa.PessoaServico.Pessoa
import pt.transporte.comboio.utils.DButils.dbQuery

@Serializable
data class ViagemExposed(val id: Int, val linha: LinhaExposed,
                         val direcao: Char = 'S',
                         val comboio: ComboioExposed)

class ViagemServico(database: Database) {
    object Viagem: Table() {
        val id = integer("id").autoIncrement()
        val linha = reference("id_linha", LinhaServico.Linha.id)
        val direcao = char("direcao")
        val comboio = reference("id_comboio", ComboioServico.Comboio.id)

        override val primaryKey = PrimaryKey(id)
    }

    init {
        transaction {
            SchemaUtils.create(Viagem)
        }
    }

    suspend fun criar(viagem: ViagemExposed) {
        dbQuery {
            Viagem.insert {
                it[Viagem.linha] = viagem.linha.id
                it[Viagem.direcao] = viagem.direcao
                it[Viagem.comboio] = viagem.comboio.id
            }
        }
    }

    suspend fun ler(id:Int = -1): List<ViagemExposed> { // refazer, groupby desnecessário
        return dbQuery {
            val resultado = (Viagem innerJoin LinhaServico.Linha
                    innerJoin ComboioServico.Comboio)
                .selectAll()
                .groupBy { if (id != -1) id else Viagem.id }

            resultado.map { (_, linhas) ->
                val primeira = linhas.first()
                val linha = LinhaExposed(primeira[LinhaServico.Linha.id],
                    primeira[LinhaServico.Linha.nome] )
                //val condutor = PessoaExposed(primeira[Pessoa.nome], primeira[Pessoa.nif])
                val comboio = ComboioExposed(primeira[ComboioServico.Comboio.id],
                    primeira[ComboioServico.Comboio.modelo])
                ViagemExposed(primeira[Viagem.id], linha, primeira[Viagem.direcao],
                    comboio)
            }
        }

    }
}