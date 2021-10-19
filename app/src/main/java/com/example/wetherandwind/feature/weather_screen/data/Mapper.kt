package com.example.wetherandwind.feature.weather_screen.data

import com.example.wetherandwind.feature.weather_screen.data.api.model.WeatherModel
import com.example.wetherandwind.feature.weather_screen.data.api.model.WeatherWindModel
import com.example.wetherandwind.feature.weather_screen.domain.model.WeatherDomainModel
import com.example.wetherandwind.feature.weather_screen.domain.model.WindDomainModel

fun WeatherModel.toDomain() = WeatherDomainModel (
    temperature = main.temp,
    humidity = main.humidity,
    tempMax = main.tempMax,
    tempMin = main.tempMin,
    windDomainModel = wind.toDomain()
)

fun WeatherWindModel.toDomain() = WindDomainModel(
    speed = speed,
    degree = degree
)