package com.hallelujah.daily.weather.core.model

import com.google.gson.annotations.SerializedName

data class Clouds(
		@SerializedName("all") val all: Int?
)