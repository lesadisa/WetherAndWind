package com.example.wetherandwind.feature.city_screen.domain

import com.example.wetherandwind.feature.city_screen.data.api.CityRepo
import com.example.wetherandwind.feature.city_screen.domain.model.CityDomainModel

class CityInteractor(private val repository: CityRepo) {
    suspend fun getCities(prefixName: String): CityDomainModel {
        return repository.getCities(prefixName)
    }
}