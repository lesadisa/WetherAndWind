package com.example.wetherandwind.feature.weather_screen.domain.model

data class WeatherDomainModel(
    val temperature: Double,
    val humidity: Int,
    val tempMax: Double,
    val tempMin: Double,
    val windDomainModel: WindDomainModel
)