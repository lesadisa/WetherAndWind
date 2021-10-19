package com.example.wetherandwind.feature.weather_screen.data.api.model

import com.google.gson.annotations.SerializedName

class WeatherWindModel(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val degree: Int
) {
}