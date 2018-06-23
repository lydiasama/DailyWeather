package com.hallelujah.daily.weather.core.model

import com.google.gson.annotations.SerializedName

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