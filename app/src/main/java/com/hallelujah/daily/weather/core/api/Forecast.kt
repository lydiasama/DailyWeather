package com.hallelujah.daily.weather.core.api

import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.core.model.ForecastWeatherResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ForecastAPI {

    @GET("forecast")
    fun getForecastWeather(
            @Query("q") city: String,
            @Query("units") unit: String,
            @Query("mode") mode: String,
            @Query("appid") API_KEY: String): Call<ForecastWeatherResponseModel>
}