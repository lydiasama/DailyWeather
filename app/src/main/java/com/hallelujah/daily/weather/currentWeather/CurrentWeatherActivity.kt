package com.hallelujah.daily.weather.currentWeather

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.HUMIDITY
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.TEMP
import com.hallelujah.daily.weather.forecast.ForecastActivity
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_current_weather.*

class CurrentWeatherActivity : AppCompatActivity() {
    private lateinit var city : String

    private lateinit var humidity : String
    private lateinit var temp : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)
        getCurrentWeatherFromSharedPreference()
        setupView()
        setOnClickListener()
    }

    private fun getCurrentWeatherFromSharedPreference() {
        this.city = Hawk.get(CITY)
        this.humidity = Hawk.get(HUMIDITY)
        this.temp = Hawk.get(TEMP)
    }

    private fun setupView() {
        tvTemp.text = temp
        tvHumidity.text = getString(R.string.humidity, humidity)
    }

    private fun setOnClickListener() {
        btnWholeDayForeCast.setOnClickListener {
            gotoForecastActivity()
        }
    }

    private fun gotoForecastActivity() {
        startActivity(Intent(this, ForecastActivity::class.java))
    }

}
