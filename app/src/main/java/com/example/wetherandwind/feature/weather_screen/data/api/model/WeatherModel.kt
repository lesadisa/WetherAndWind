package com.example.wetherandwind.feature.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("main")
    val main: WeatherMainModel,
    @SerializedName("wind")
    val wind: WeatherWindModel
)