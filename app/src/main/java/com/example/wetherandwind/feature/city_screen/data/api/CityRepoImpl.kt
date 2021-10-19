package com.example.wetherandwind.feature.city_screen.data.api

import com.example.wetherandwind.feature.city_screen.data.toDomain
import com.example.wetherandwind.feature.city_screen.domain.model.CityDomainModel

class CityRepoImpl(val source: CityRemoteSource):CityRepo {
    override suspend fun getCities(prefixName: String): CityDomainModel {
        return source.getCities(prefixName, "5","0").toDomain()
    }
}