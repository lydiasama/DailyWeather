package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.DailyWeatherException
import com.hallelujah.daily.weather.NOT_FOUND
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.model.ForecastWeatherResponseModel
import com.hallelujah.daily.weather.forecast.ForecastView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ForecastWeatherCallback(var view: ForecastView) {
    private val callback = object : Callback<ForecastWeatherResponseModel> {
        override fun onResponse(call: Call<ForecastWeatherResponseModel>, response: Response<ForecastWeatherResponseModel>) {
            Log.d("FORCAST", "Success")
            response.body()?.apply {
                list?.let {
                    view.displayAllDayForcast(it)
                }
            }
        }

        override fun onFailure(call: Call<ForecastWeatherResponseModel>, t: Throwable) {
            Log.d("FORCAST", "Failure")
            if (t is DailyWeatherException) {
                when (t.code) {
                    NOT_FOUND -> t.message = view.getContext().getString(R.string.dialog_not_found_city)
                }
                view.displayDialog(message = t.message)
            }
        }
    }

    fun getForecastWeatherCallback(): Callback<ForecastWeatherResponseModel> = callback
}