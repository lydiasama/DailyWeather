package com.hallelujah.daily.weather.core.model

import com.google.gson.annotations.SerializedName

data class Rain(
		@SerializedName("3h") val hhh: Double?
)