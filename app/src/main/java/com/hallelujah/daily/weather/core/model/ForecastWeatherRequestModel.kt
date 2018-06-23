package com.hallelujah.daily.weather.core.model

import com.google.gson.annotations.SerializedName
import com.hallelujah.daily.weather.API_KEY
import com.hallelujah.daily.weather.API_MODE


data class ForecastWeatherRequestModel(
        @SerializedName("city") val city: String,
        @SerializedName("unit") val unit: String,
        @SerializedName("mode") val mode: String = API_MODE,
        @SerializedName("apiKey") val apiKey: String = API_KEY
)