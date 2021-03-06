package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.*
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.currentWeather.CurrentWeatherView
import com.orhanobut.hawk.Hawk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherChangeUnitCallback(var view: CurrentWeatherView) {
    private val callback = object : Callback<CurrentWeatherResponseModel> {
        override fun onResponse(call: Call<CurrentWeatherResponseModel>, response: Response<CurrentWeatherResponseModel>) {
            Log.d("WEATHER", "Success")
            response.body()?.apply {
                Hawk.put(TEMP, main?.temp.toString())
                Hawk.put(HUMIDITY, main?.humidity.toString())
                view.updateCurrentWeather(this)
            }
        }

        override fun onFailure(call: Call<CurrentWeatherResponseModel>, t: Throwable) {
            Log.d("WEATHER", "Failure")
            if (t is DailyWeatherException) {
                when (t.code) {
                    NOT_FOUND -> t.message = view.getContext().getString(R.string.dialog_not_found_city)
                }
                view.displayDialog(message = t.message)
            }
        }
    }

    fun getCurrentWeatherChangeUnitCallback(): Callback<CurrentWeatherResponseModel> = callback
}