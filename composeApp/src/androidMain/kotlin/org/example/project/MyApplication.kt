package org.example.project

import android.app.Application
import di.ClientModules
import org.example.project.presentation.component.DI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(ClientModules())
            modules(viewModelModule)
        }
    }
}