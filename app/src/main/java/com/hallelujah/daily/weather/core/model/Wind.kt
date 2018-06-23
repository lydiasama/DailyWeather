package com.hallelujah.daily.weather.core.model

import com.google.gson.annotations.SerializedName

data class Wind(
        @SerializedName("speed") val speed: Double?,
        @SerializedName("deg") val deg: Double?
)