package com.hallelujah.daily.weather.core.network

import com.hallelujah.daily.weather.API_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal fun createRetrofit(): Retrofit {

    return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}