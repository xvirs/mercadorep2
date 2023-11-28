package domain.interfaces

import domain.models.AutoParte
import kotlinx.coroutines.flow.Flow

interface ReplacementRepositoryInterface {
    suspend fun getReplacement() : Flow<List<AutoParte>>
}