package com.example.wetherandwind.feature.city_screen.data.api.model

import com.google.gson.annotations.SerializedName

data class CityModel(@SerializedName("data") val data: List<CityMainModel>) {
}