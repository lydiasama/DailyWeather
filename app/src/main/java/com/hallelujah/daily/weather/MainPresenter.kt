package com.hallelujah.daily.weather

import com.hallelujah.daily.weather.core.api.WeatherAPI
import com.hallelujah.daily.weather.core.callback.CurrentWeatherCallback
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.core.network.createRetrofit
import retrofit2.Retrofit


interface MainView {
    fun gotoWeatherActivity()
}

class MainPresenter(val view: MainView) {

    fun callServiceGetCurrentWeather(city: String, unit: String) {
        val retrofit: Retrofit = createRetrofit()
        val weatherAPI = retrofit.create(WeatherAPI::class.java)
        weatherAPI.getCurrentWeather(
                city = city,
                unit = unit,
                API_KEY = API_KEY
        ).enqueue(object : CurrentWeatherCallback<CurrentWeatherResponseModel>(view) {})
    }

}