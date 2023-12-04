package data.datasource


import data.interfaces.ReplacementDataSourceRemoteInterface
import data.models.AutoParteDTO
import data.network.BaseClient
import domain.models.AutoParte
import domain.models.StatusResult
import io.ktor.client.call.body
import io.ktor.serialization.JsonConvertException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class ReplacementDataSourceRemote() : ReplacementDataSourceRemoteInterface {

    companion object {
        const val BASE_URL: String = "https://b31962a72f2840dd9fd5af71a55d158d.api.mockbin.io/"
        val baseClient: BaseClient = BaseClient()
    }

    override suspend fun getReplacement(): StatusResult<List<AutoParte>> =
        withContext(Dispatchers.IO) {
            when (val res = fetchReplacement("", "fail to send petition")) {
                is StatusResult.Error -> StatusResult.Error(res.message)
                is StatusResult.Success -> StatusResult.Success(res.value.auto_partes)
            }
        }


    private suspend fun fetchReplacement(
        url: String,
        messageError: String
    ): StatusResult<AutoParteDTO> {
        val httpResult = baseClient.get(BASE_URL, messageError)
        try {
            httpResult.httpResponse?.let { return StatusResult.Success(value = it.body()) }
            return StatusResult.Error(httpResult.errorMessage)
        } catch (e: JsonConvertException) {
            return StatusResult.Error(messageError)
        }
    }
}