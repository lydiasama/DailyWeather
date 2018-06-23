package com.hallelujah.daily.weather.core.model
import com.google.gson.annotations.SerializedName

data class ForecastWeatherResponseModel(
		@SerializedName("cod") val cod: String?,
		@SerializedName("message") val message: Double?,
		@SerializedName("cnt") val cnt: Int?,
		@SerializedName("list") val list: List<Item6?>?
)

data class Item6(
		@SerializedName("dt") val dt: Int?,
		@SerializedName("main") val main: Main?,
		@SerializedName("weather") val weather: List<Weather?>?,
		@SerializedName("clouds") val clouds: Clouds?,
		@SerializedName("wind") val wind: Wind?,
		@SerializedName("rain") val rain: Rain?,
		@SerializedName("sys") val sys: Sys?,
		@SerializedName("dt_txt") val dtTxt: String?
)