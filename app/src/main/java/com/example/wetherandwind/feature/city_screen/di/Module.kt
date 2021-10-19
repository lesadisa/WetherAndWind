package com.example.wetherandwind.feature.city_screen.di

import com.example.wetherandwind.feature.city_screen.data.api.CityApi
import com.example.wetherandwind.feature.city_screen.data.api.CityRemoteSource
import com.example.wetherandwind.feature.city_screen.data.api.CityRepo
import com.example.wetherandwind.feature.city_screen.data.api.CityRepoImpl
import com.example.wetherandwind.feature.city_screen.domain.CityInteractor
import com.example.wetherandwind.feature.city_screen.ui.CityScreenViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "http://geodb-free-service.wirefreethought.com/"
val appModule = module {

    single<OkHttpClient> (named("http2")) {
        OkHttpClient.Builder()
            .build()
    }

    single<Retrofit>( named("retrofit2")) {
        Retrofit.Builder()
            .baseUrl(com.example.wetherandwind.feature.city_screen.di.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named("http2")))
            .build()
    }

    single<CityApi> {
        get<Retrofit>(named("retrofit2")).create(CityApi::class.java)
    }

    single<CityRemoteSource> {
        CityRemoteSource(get<CityApi>())
    }


    single<CityRepo> {
        CityRepoImpl(get<CityRemoteSource>())
    }

    single<CityInteractor> {
        CityInteractor(get<CityRepo>())
    }

    viewModel() {
        CityScreenViewModel(get<CityInteractor>())
    }
}