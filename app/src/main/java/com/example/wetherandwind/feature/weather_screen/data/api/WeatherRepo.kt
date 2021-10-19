package com.example.wetherandwind.feature.weather_screen.data.api

import com.example.wetherandwind.feature.weather_screen.domain.model.WeatherDomainModel

interface WeatherRepo {
    suspend fun getWeather(city: String): WeatherDomainModel
}