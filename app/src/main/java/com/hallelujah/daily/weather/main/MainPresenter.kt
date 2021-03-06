package com.hallelujah.daily.weather.main

import com.hallelujah.daily.weather.API_KEY
import com.hallelujah.daily.weather.DailyWeather
import com.hallelujah.daily.weather.core.BaseView
import com.hallelujah.daily.weather.core.api.WeatherAPI
import com.hallelujah.daily.weather.core.callback.CurrentWeatherCallback
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.core.network.NetworkCallback


interface MainView : BaseView {
    fun gotoCurrentWeatherActivity(iconName: String?)
}

class MainPresenter(val view: MainView) {

    fun callServiceGetCurrentWeather(city: String, unit: String) {
        val weatherAPI = DailyWeather.client.create(WeatherAPI::class.java)
        weatherAPI.getCurrentWeather(
                city = city,
                unit = unit,
                API_KEY = API_KEY
        ).enqueue(object : NetworkCallback<CurrentWeatherResponseModel>(view, CurrentWeatherCallback(view).getCurrentWeatherCallback()) {})
    }

}