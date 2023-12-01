package di

import data.network.BaseClient
import data.datasource.ReplacementDataSourceRemote
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun initKoin() {
    startKoin {
        modules(privateModule)
    }
}

val privateModule = module {
    // Define tus dependencias privadas aquí
    single { BaseClient() }
    single { ReplacementDataSourceRemote(get()) }
}
