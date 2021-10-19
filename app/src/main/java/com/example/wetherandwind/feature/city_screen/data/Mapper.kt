package com.example.wetherandwind.feature.city_screen.data

import com.example.wetherandwind.feature.city_screen.data.api.model.CityModel
import com.example.wetherandwind.feature.city_screen.domain.model.CityDomainModel

fun CityModel.toDomain(): CityDomainModel {
    val filterList = this.data.filter { it.type=="CITY"}
    val mapList = filterList.map { it.city }
    val sortedList = mapList.sortedBy { it }

    return CityDomainModel(
        sortedList
    )
}