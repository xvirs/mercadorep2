package org.example.project.presentation.component.DI

import data.datasource.ReplacementDataSourceRemote
import data.repository.ReplacementRepository
import domain.usecase.ReplacementUseCase
import org.example.project.presentation.component.UI.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module



val ClientModules = module {
    // Define tus dependencias comunes aquí
    // Ejemplo:
    single { ReplacementDataSourceRemote() }
    single { ReplacementRepository(get<ReplacementDataSourceRemote>()) }
    single { ReplacementUseCase(get<ReplacementRepository>()) }
}

val viewModelModule = module {

    // Define el ViewModel y proporciónale el ReplacementUseCase inyectado
    viewModelOf(::HomeViewModel)

}