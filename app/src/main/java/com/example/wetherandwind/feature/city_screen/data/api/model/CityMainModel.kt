package com.example.wetherandwind.feature.city_screen.data.api.model

import com.google.gson.annotations.SerializedName

class CityMainModel(
    @SerializedName("type")
    val type: String,
    @SerializedName("city")
    val city: String
)