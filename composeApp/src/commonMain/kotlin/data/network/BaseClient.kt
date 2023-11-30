package data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*



class BaseClient() {
    companion object {
        internal const val BASE_URL = ""
    }

     val apiClient : HttpClient= HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }


}