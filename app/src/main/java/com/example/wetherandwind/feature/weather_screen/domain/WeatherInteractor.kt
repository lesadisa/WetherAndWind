package com.example.wetherandwind.feature.weather_screen.domain

import com.example.wetherandwind.feature.weather_screen.data.api.WeatherRepo
import com.example.wetherandwind.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherInteractor(private val repository: WeatherRepo) {
    suspend fun getWeather(city: String): WeatherDomainModel {
        return repository.getWeather(city)
    }
}