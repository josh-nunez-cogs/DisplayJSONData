package com.example.displayjsondata

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DisplayJSONDataApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@DisplayJSONDataApplication)
            modules(appModule)
        }
    }
}