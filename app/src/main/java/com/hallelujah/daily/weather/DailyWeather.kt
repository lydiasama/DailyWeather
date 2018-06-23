package com.hallelujah.daily.weather

import android.app.Application
import com.hallelujah.daily.weather.core.network.createRetrofit
import com.orhanobut.hawk.Hawk
import retrofit2.Retrofit

class DailyWeather : Application() {

    companion object {
        @JvmStatic
        lateinit var client: Retrofit
    }

    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
        client = createRetrofit()
    }
}