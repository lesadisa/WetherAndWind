package com.example.wetherandwind

import android.app.Application
import com.example.wetherandwind.feature.weather_screen.di.appModule as appModuleWeather
import com.example.wetherandwind.feature.city_screen.di.appModule as appModuleWind
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin


class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin{
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(appModuleWeather, appModuleWind)
        }
    }
}