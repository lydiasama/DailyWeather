package com.hallelujah.daily.weather

import android.app.Application
import com.orhanobut.hawk.Hawk

class DailyWeather : Application() {
    override fun onCreate() {
        super.onCreate()
        Hawk.init(this).build()
    }
}