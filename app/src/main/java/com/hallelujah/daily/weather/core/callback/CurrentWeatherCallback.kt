package com.hallelujah.daily.weather.core.callback

import android.util.Log
import com.hallelujah.daily.weather.main.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CurrentWeatherCallback<CurrentWeatherResponseModel>(var view: MainView): Callback<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel> {


    override fun onFailure(call: Call<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>?, t: Throwable?) {
        Log.d("WEATHER" ,"Failure")
    }

    override fun onResponse(call: Call<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>, response: Response<com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel>) {
        Log.d("WEATHER" ,response.isSuccessful.toString())
        Log.d("WEATHER" ,response.body()?.main?.temp.toString())
    }

}