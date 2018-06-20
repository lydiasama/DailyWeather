package com.hallelujah.daily.weather.core.callback

import com.hallelujah.daily.weather.MainView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

open class CurrentWeatherCallback<CurrentWeatherResponseModel>(var view: MainView): Callback<CurrentWeatherResponseModel> {


    override fun onFailure(call: Call<CurrentWeatherResponseModel>?, t: Throwable?) {

    }

    override fun onResponse(call: Call<CurrentWeatherResponseModel>, response: Response<CurrentWeatherResponseModel>) {

    }

}