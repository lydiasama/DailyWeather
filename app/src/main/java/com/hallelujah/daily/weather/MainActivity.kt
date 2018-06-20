package com.hallelujah.daily.weather

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnCurrentWeather.setOnClickListener {
            mainPresenter.callServiceGetCurrentWeather(city = "Bangkok", unit = "metric")
        }
    }

    override fun gotoWeatherActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
