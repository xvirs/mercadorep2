package org.example.project

import android.app.Application
import org.example.project.presentation.component.DI.ClientModules
import org.example.project.presentation.component.DI.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()


        startKoin {
            androidContext(this@MyApplication)
            androidLogger()
            modules(viewModelModule, ClientModules)
        }
    }
}