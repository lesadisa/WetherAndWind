package com.example.wetherandwind.feature.weather_screen.data.api

import com.example.wetherandwind.feature.weather_screen.data.api.model.WeatherModel

class WeatherRemoteSource(val api: WeatherApi) {
    suspend fun getWeather(cityName: String) : WeatherModel {
        return api.getWeather(cityName)
    }
}