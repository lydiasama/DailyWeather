package com.hallelujah.daily.weather.forecast

import com.hallelujah.daily.weather.API_KEY
import com.hallelujah.daily.weather.API_MODE
import com.hallelujah.daily.weather.DailyWeather
import com.hallelujah.daily.weather.core.BaseView
import com.hallelujah.daily.weather.core.api.ForecastAPI
import com.hallelujah.daily.weather.core.callback.ForecastWeatherCallback
import com.hallelujah.daily.weather.core.model.ForecastWeatherResponseModel
import com.hallelujah.daily.weather.core.network.NetworkCallback


interface ForecastView : BaseView {
    fun gotoAllDayForcast()
}

class ForecastPresenter(val view: ForecastView) {

    fun callServiceGetForcast(city: String, unit: String) {
        val weatherAPI = DailyWeather.client.create(ForecastAPI::class.java)
        weatherAPI.getForecastWeather(
                city = city,
                unit = unit,
                mode = API_MODE,
                API_KEY = API_KEY
        ).enqueue(object : NetworkCallback<ForecastWeatherResponseModel>(view, ForecastWeatherCallback(view).getForecastWeatherCallback()) {})
    }





}