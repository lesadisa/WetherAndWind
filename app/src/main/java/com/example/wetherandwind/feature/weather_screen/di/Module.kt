package com.example.wetherandwind.feature.weather_screen.di

import com.example.wetherandwind.feature.weather_screen.data.api.WeatherApi
import com.example.wetherandwind.feature.weather_screen.data.api.WeatherRemoteSource
import com.example.wetherandwind.feature.weather_screen.data.api.WeatherRepo
import com.example.wetherandwind.feature.weather_screen.data.api.WeatherRepoImpl
import com.example.wetherandwind.feature.weather_screen.domain.WeatherInteractor
import com.example.wetherandwind.feature.weather_screen.ui.WeatherScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://api.openweathermap.org/"
val appModule = module {

single<OkHttpClient> (named("http1")){
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit> (named("retrofit1")){
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("http1")))
            .build()
    }

    // singleton, который входит в API
    single<WeatherApi> {
        get<Retrofit>(named("retrofit1")).create(WeatherApi::class.java)
    }

    single<WeatherRemoteSource> {
        WeatherRemoteSource(get<WeatherApi>())
    }


    single<WeatherRepo> {
        WeatherRepoImpl(get<WeatherRemoteSource>())
    }

    single<WeatherInteractor> {
        WeatherInteractor(get<WeatherRepo>())
    }

    viewModel() {
        WeatherScreenViewModel(get<WeatherInteractor>())
    }
}