package com.example.wetherandwind.feature.weather_screen.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wetherandwind.feature.weather_screen.domain.WeatherInteractor
import com.example.wetherandwind.feature.weather_screen.domain.model.WeatherDomainModel
import kotlinx.coroutines.launch

class WeatherScreenViewModel(private val weatherInteractor: WeatherInteractor) : ViewModel(){
    val liveData: MutableLiveData<WeatherDomainModel> = MutableLiveData()

    fun requestWeather(city: String) {
        viewModelScope.launch {
            liveData.postValue(weatherInteractor.getWeather(city))
        }
    }
}