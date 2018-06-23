package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.*
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.currentWeather.CurrentWeatherView
import com.hallelujah.daily.weather.main.MainView
import com.orhanobut.hawk.Hawk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CurrentWeatherCallback(var view: MainView) {
    private val callback = object : Callback<CurrentWeatherResponseModel> {
        override fun onResponse(call: Call<CurrentWeatherResponseModel>, response: Response<CurrentWeatherResponseModel>) {
            Log.d("WEATHER", "Success")
            response.body()?.apply {
                Hawk.put(TEMP, main?.temp.toString())
                Hawk.put(HUMIDITY, main?.humidity.toString())

                val weather = weather
                weather?.let {
                    if (it.isNotEmpty())
                        view.gotoCurrentWeatherActivity(it[0].icon.toString())
                    else
                        view.gotoCurrentWeatherActivity(null)
                }
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

    fun getCurrentWeatherCallback(): Callback<CurrentWeatherResponseModel> = callback
}