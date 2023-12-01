package org.example.project.presentation.component.DI

import domain.usecase.ReplacementUseCase
import org.example.project.presentation.component.UI.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

 val viewModelModule = module {
    // Define tus dependencias comunes aquí
    // Ejemplo:
    single { ReplacementUseCase(get()) }

    // Define el ViewModel y proporciónale el ReplacementUseCase inyectado
    viewModel { HomeViewModel(get()) }
}