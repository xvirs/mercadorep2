package data.interfaces

import domain.models.AutoParte
import kotlinx.coroutines.flow.Flow

interface ReplacementDataSourceRemoteInterface {
    suspend fun getReplacement() : Flow<List<AutoParte>>
}