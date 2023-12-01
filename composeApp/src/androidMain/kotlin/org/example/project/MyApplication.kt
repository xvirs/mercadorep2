package org.example.project

import android.app.Application
import di.initKoin
import domain.usecase.ReplacementUseCase
import org.example.project.presentation.component.UI.HomeViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

class MyApplication : Application() {

    private val viewModelModule = module {
        // Define tus dependencias comunes aquí
        // Ejemplo:
        single { ReplacementUseCase(get()) }

        // Define el ViewModel y proporciónale el ReplacementUseCase inyectado
        viewModel { HomeViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        initKoin()
        startKoin {
            androidContext(this@MyApplication)
            modules(viewModelModule)
        }
    }
}