package com.example.wetherandwind.feature.city_screen.data.api

import com.example.wetherandwind.feature.city_screen.data.api.model.CityModel
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {
    @GET("v1/geo/cities")
    suspend fun getCities(
        @Query("namePrefix") namePrefix: String = "",
        @Query("hateoasMode") hateoasMode: Boolean = false,
        @Query("limit") limit: String = "5",
        @Query("offset") offset: String = "0"
    ): CityModel
}