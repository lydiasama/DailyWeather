package com.hallelujah.daily.weather.core.model
import com.google.gson.annotations.SerializedName

data class ForecastWeatherResponseModel(
		@SerializedName("cod") val cod: String?,
		@SerializedName("message") val message: Double?,
		@SerializedName("cnt") val cnt: Int?,
		@SerializedName("list") val list: ArrayList<ItemForecast>?
)

