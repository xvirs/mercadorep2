package data.datasource

import data.interfaces.ReplacementDataSourceRemoteInterface
import domain.models.AutoParte
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class ReplacementDataSourceRemote(): ReplacementDataSourceRemoteInterface {

    //TODO Logica de KTOR para peticiones http
    override suspend fun getReplacement(): Flow<List<AutoParte>> {
        withContext(Dispatchers.IO){

        }
    }
}