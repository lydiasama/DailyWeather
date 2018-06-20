package com.hallelujah.daily.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), MainView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun gotoWeatherActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
