package di

import data.datasource.ReplacementDataSourceRemote
import data.network.BaseClient
import org.koin.dsl.module


    fun ClientModules() = module {
        single { BaseClient() }
        single { ReplacementDataSourceRemote(get()) }
    }

