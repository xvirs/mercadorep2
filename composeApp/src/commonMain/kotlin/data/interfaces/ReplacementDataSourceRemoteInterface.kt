package data.interfaces

import domain.models.AutoParte
import domain.models.StatusResult

interface ReplacementDataSourceRemoteInterface {
    suspend fun getReplacement() : StatusResult<List<AutoParte>>
}