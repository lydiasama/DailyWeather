package com.hallelujah.daily.weather.core.model
import com.google.gson.annotations.SerializedName
import com.hallelujah.daily.weather.API_KEY


data class CurrentWeatherRequestModel(
		@SerializedName("city") val city: String,
		@SerializedName("unit") val unit: String,
		@SerializedName("apiKey") val apiKey: String = API_KEY
)