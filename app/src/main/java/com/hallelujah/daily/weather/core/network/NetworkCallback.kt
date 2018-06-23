package com.hallelujah.daily.weather.core.network

import com.hallelujah.daily.weather.DailyWeatherException
import com.hallelujah.daily.weather.core.BaseView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


open class NetworkCallback<T>(private val view: BaseView, private val mCallback: Callback<T>) : Callback<T> {

    companion object {
        private val TAG = "RetrofitCallback"
    }

    override fun onResponse(call: Call<T>, response: Response<T>) {
        when {
            response.isSuccessful -> mCallback.onResponse(call, response)
            else -> mCallback.onFailure(call,
                    DailyWeatherException(
                            code = response.code().toString(),
                            message = response.message()
                    ))
        }
    }

    override fun onFailure(call: Call<T>, t: Throwable) {
        mCallback.onFailure(call, t)
    }

}