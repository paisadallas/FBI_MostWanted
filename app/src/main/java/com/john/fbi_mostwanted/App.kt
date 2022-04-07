package com.john.fbi_mostwanted

import android.app.Application
import com.john.fbi_mostwanted.di.applicationModule
import com.john.fbi_mostwanted.di.networkModule
import com.john.fbi_mostwanted.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(networkModule, applicationModule, viewModelModule))
        }
    }
}