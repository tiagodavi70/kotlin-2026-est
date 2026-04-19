package pt.org.comboio.pessoa

import kotlinx.serialization.Serializable

@Serializable
data class Utilizador(val nome: String, val nif: String)