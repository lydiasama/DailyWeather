package com.hallelujah.daily.weather

data class DailyWeatherException (var code: String, override var message: String) : Throwable() {
    companion object {
        const val APP_COMMON_ERROR = "APP_COMMON_ERROR"
        const val RESPONSE_IS_NULL = "RESPONSE_IS_NULL"
    }
}