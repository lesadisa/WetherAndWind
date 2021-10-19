package com.example.wetherandwind.feature.weather_screen.data.api

import com.example.wetherandwind.feature.weather_screen.data.toDomain
import com.example.wetherandwind.feature.weather_screen.domain.model.WeatherDomainModel

class WeatherRepoImpl(private val source: WeatherRemoteSource): WeatherRepo {
    override suspend fun getWeather(city: String): WeatherDomainModel {
        return source.getWeather(city).toDomain()
    }
}