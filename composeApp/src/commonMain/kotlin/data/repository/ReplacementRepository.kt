package data.repository

import data.interfaces.ReplacementDataSourceRemoteInterface
import domain.interfaces.ReplacementRepositoryInterface
import domain.models.AutoParte
import domain.models.StatusResult

class ReplacementRepository (private val dataSource: ReplacementDataSourceRemoteInterface): ReplacementRepositoryInterface {
    override suspend fun getReplacement(): StatusResult<List<AutoParte>> {
        return when(val response = dataSource.getReplacement()){
            is StatusResult.Error -> StatusResult.Error(response.message)
            is StatusResult.Success -> StatusResult.Success(response.value)
        }
    }
}