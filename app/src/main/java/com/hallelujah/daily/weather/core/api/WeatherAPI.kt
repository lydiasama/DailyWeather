package com.hallelujah.daily.weather.core.api

import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface WeatherAPI {

    @GET("weather?q={city}&units={unit}&appid={API_KEY}")
    fun getCurrentWeather(
            @Path("city") city: String,
            @Path("unit") unit: String,
            @Path("API_KEY") API_KEY: String): Call<CurrentWeatherResponseModel>
}