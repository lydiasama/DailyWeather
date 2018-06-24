package com.hallelujah.daily.weather

const val API_URL = "http://api.openweathermap.org/data/2.5/"
const val API_KEY = "a5785043086e07a8483a305abf1b4742"
const val API_MODE = "json"
const val CELSIUS_UNIT = "metric"
const val FAHRENHEIT_UNIT = "imperial"
const val DEFAULT_UNIT = CELSIUS_UNIT
const val FORECAST_DAY = 1   // between 1-5

const val PATTERN_DATE_RESPONSE = "yyyy-MM-dd HH:mm:ss"
const val PATTERN_TIME = "HH:mm:ss"
const val PATTERN_SMALL_DATE = "dd/MM/YYYY"

// Shared Preference Key
const val TEMP = "TEMP"
const val HUMIDITY = "HUMIDITY"
const val CITY = "CITY"
const val DEGREE_UNIT = "DEGREE_UNIT"

// Intent
const val INTENT_ICON_NAME = "ICON_NAME"

// Error Code
const val NOT_FOUND = "404"
