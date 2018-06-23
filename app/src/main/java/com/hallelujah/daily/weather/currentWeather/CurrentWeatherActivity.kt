package com.hallelujah.daily.weather.currentWeather

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hallelujah.daily.weather.*
import com.hallelujah.daily.weather.forecast.ForecastActivity
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_current_weather.*

class CurrentWeatherActivity : AppCompatActivity() {
    private lateinit var city : String
    private lateinit var humidity : String
    private lateinit var temp : String
    private lateinit var iconName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)
        getIconNameFromeIntent()
        setupIconWeather()
        getCurrentWeatherFromSharedPreference()
        setupView()
        setOnClickListener()
    }

    private fun getIconNameFromeIntent() {
        this.iconName = intent.getStringExtra(INTENT_ICON_NAME)
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

    private fun setupIconWeather() {
        val url = "http://openweathermap.org/img/w/$iconName.png"
        Picasso.with(this).load(url).into(ivWeather)
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
