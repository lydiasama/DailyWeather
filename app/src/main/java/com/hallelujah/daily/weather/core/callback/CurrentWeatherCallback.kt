package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.HUMIDITY
import com.hallelujah.daily.weather.TEMP
import com.hallelujah.daily.weather.DailyWeatherException
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
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
                Hawk.put(CITY, name)
                view.gotoCurrentWeatherActivity()
            }
        }

        override fun onFailure(call: Call<CurrentWeatherResponseModel>, t: Throwable) {
            Log.d("WEATHER", "Failure")
            if (t is DailyWeatherException) {
                view.displayDialog(message = t.message)
            }
        }
    }

    fun getCurrenWeatherCallback(): Callback<CurrentWeatherResponseModel> = callback
}