package domain.interfaces

import domain.models.AutoParte
import domain.models.StatusResult

interface ReplacementRepositoryInterface {
    suspend fun getReplacement() : StatusResult<List<AutoParte>>
}