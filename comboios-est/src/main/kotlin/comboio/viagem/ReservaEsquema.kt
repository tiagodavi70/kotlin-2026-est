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
import pt.transporte.comboio.comboio.ComboioServico.Comboio
import pt.transporte.comboio.comboio.LugarExposed
import pt.transporte.comboio.comboio.LugarServico.Lugar
import pt.transporte.comboio.linha.LinhaExposed
import pt.transporte.comboio.linha.LinhaServico.Linha
import pt.transporte.comboio.utils.DButils.dbQuery
import pt.transporte.comboio.viagem.ViagemServico.Viagem

@Serializable
data class ReservaExposed(val lugar: LugarExposed, val viagem: ViagemExposed)

class ReservaServico(database: Database) {
    object Reserva: Table() {
        val lugar = reference("id_lugar", Lugar.id)
        val viagem = reference("id_viagem", Viagem.id)

        override val primaryKey = PrimaryKey(lugar, viagem)
    }

    init {
        transaction {
            SchemaUtils.create(Reserva)
        }
    }

    suspend fun criar(reserva: ReservaExposed) {
        dbQuery {
            Reserva.insert {
                it[Reserva.lugar] = reserva.lugar.id
                it[Reserva.viagem] = reserva.viagem.id
            }
        }
    }

    suspend fun ler(): List<ReservaExposed> {
        return dbQuery {
            (Reserva innerJoin Lugar innerJoin Viagem)
                .selectAll()
                .map {
                    val idComboio = Lugar.select(Lugar.comboio)
                        .where { Lugar.id eq it[Lugar.id]}
                        .map { l -> l[Lugar.comboio] }
                        .single()

                    val comboio = Comboio.selectAll()
                        .where { Comboio.id eq idComboio }
                        .map { l-> ComboioExposed(l[Comboio.id], l[Comboio.modelo]) }
                        .single()

                    val lugar = LugarExposed(it[Lugar.id], it[Lugar.assento], comboio)

                    val linha = Linha.selectAll()
                        .where { Linha.id eq it[Viagem.linha] }
                        .map{ l-> LinhaExposed(l[Linha.id], l[Linha.nome]) }
                        .single()

                    val viagem = ViagemExposed(it[Viagem.id], linha,
                        it[Viagem.direcao], comboio)

                    ReservaExposed(lugar, viagem)
                }
        }
    }
}