package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.TEMP
import com.hallelujah.daily.weather.HUMIDITY
import com.hallelujah.daily.weather.main.MainView
import com.orhanobut.hawk.Hawk
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CurrentWeatherCallback<CurrentWeatherResponseModel>(var view: MainView) : Callback<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel> {


    override fun onFailure(call: Call<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>?, t: Throwable?) {
        Log.d("WEATHER", "Failure")
    }

    override fun onResponse(call: Call<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>, response: Response<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>) {
        Log.d("WEATHER", response.body()?.toString())
        Log.d("HUM", response.body()?.main?.humidity.toString())
        response.body()?.apply {
            Hawk.put(TEMP, main?.temp.toString())
            Hawk.put(HUMIDITY, main?.humidity.toString())
            Hawk.put(CITY, name)
            view.gotoCurrentWeatherActivity()
        }
    }

}