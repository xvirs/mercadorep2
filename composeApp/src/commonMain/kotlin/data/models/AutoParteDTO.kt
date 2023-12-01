package data.models

import domain.models.AutoParte
import kotlinx.serialization.Serializable

@Serializable
data class AutoParteDTO(
    val auto_partes: List<AutoParte>
)
