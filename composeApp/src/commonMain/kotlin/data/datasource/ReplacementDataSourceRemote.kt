package data.datasource


import data.network.BaseClient
import data.interfaces.ReplacementDataSourceRemoteInterface
import domain.models.AutoParte
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ReplacementDataSourceRemote(private val baseClient: BaseClient): ReplacementDataSourceRemoteInterface {

    override suspend fun getReplacement(): Flow<List<AutoParte>> {
        return flow {
            val response: HttpResponse = baseClient.apiClient.get("https://b31962a72f2840dd9fd5af71a55d158d.api.mockbin.io/")
            val autoParteList: List<AutoParte> = response.body()
            emit(autoParteList)
        }
    }
}