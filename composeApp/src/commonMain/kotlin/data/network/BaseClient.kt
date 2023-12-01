package data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json


class BaseClient() {

    val apiClient: HttpClient = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(
                json = Json { ignoreUnknownKeys = true }
            )
        }
    }


    internal suspend fun get(url: String, errorMessage: String): HttpStatus {
        return try {
            val response = apiClient.get(url)
            if (response.status.value in 200..299)
                HttpStatus(httpResponse = response)
            else
                HttpStatus(errorMessage = errorMessage)
        } catch (e: Exception) {
            HttpStatus(errorMessage = "Ups! Atrapaste un error desconocido, vuelve a intentarlo")
        }
    }

}

internal data class HttpStatus(
    val httpResponse: HttpResponse? = null,
    val errorMessage : String = ""
)