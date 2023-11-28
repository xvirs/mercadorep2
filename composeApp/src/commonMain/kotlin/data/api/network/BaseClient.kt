package data.api.network

import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import kotlinx.serialization.json.Json

class BaseClient {

    companion object {
        internal const val BASE_URL = ""
    }

    private val apiClient: HttpClient = HttpClient(engine) {
        Json { ignoreUnknownKeys = true }
        install(ContentNegotiation) {
            json(
                json = Json { ignoreUnknownKeys = true }
            )
        }
    }

    val client = HttpClient {
        install(JsonFeature) {
            serializer = KotlinxSerializer(Json {
                ignoreUnknownKeys = true
            })
        }
    }
}