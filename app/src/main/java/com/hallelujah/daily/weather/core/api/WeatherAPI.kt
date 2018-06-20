package com.hallelujah.daily.weather.core.api

import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPI {

    @GET("weather")
    fun getCurrentWeather(
            @Query("q") city: String,
            @Query("units") unit: String,
            @Query("appid") API_KEY: String): Call<CurrentWeatherResponseModel>
}