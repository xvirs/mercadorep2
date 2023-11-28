package data.repository

import data.interfaces.ReplacementDataSourceRemoteInterface
import domain.interfaces.ReplacementRepositoryInterface
import domain.models.AutoParte
import kotlinx.coroutines.flow.Flow

class ReplacementRepository (private val dataSource: ReplacementDataSourceRemoteInterface): ReplacementRepositoryInterface {
    override suspend fun getReplacement(): Flow<List<AutoParte>> {
        return dataSource.getReplacement()
    }
}