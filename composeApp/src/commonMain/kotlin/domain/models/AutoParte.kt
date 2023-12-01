package domain.models

import kotlinx.serialization.Serializable

@Serializable
data class AutoParte(
    val estate: String,
    val id: Int,
    val imagen: String,
    val precio: Double,
    val titulo: String
)