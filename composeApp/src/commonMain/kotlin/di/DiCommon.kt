package di

import data.datasource.ReplacementDataSourceRemote
import data.network.BaseClient
import org.koin.dsl.module

val privateModule = module {
    // Define tus dependencias privadas aquí
    single { BaseClient() }
    single { ReplacementDataSourceRemote() }
}
