package com.hallelujah.daily.weather.currentWeather

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.hallelujah.daily.weather.*
import com.hallelujah.daily.weather.core.model.CurrentWeatherResponseModel
import com.hallelujah.daily.weather.core.util.AppUtil
import com.hallelujah.daily.weather.forecast.ForecastActivity
import com.orhanobut.hawk.Hawk
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_current_weather.*
import kotlinx.android.synthetic.main.item_swith_degree.view.*

class CurrentWeatherActivity : AppCompatActivity(), CurrentWeatherView {
    private lateinit var city: String
    private lateinit var humidity: String
    private lateinit var temp: String
    private lateinit var iconName: String

    private var currentWeatherPresenter = CurrentWeatherPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_current_weather)
        getIconNameFromeIntent()
        setupIconWeather()
        getCurrentWeatherFromSharedPreference()
        setupView()
        setOnClickListener()

        switch_degree.toggle.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.fahrenheit -> {
                    Hawk.put(DEGREE_UNIT, FAHRENHEIT_UNIT)
                    getCurrentWeatherFromService(unit = FAHRENHEIT_UNIT)

                }
                else -> {
                    Hawk.put(DEGREE_UNIT, CELSIUS_UNIT)
                    getCurrentWeatherFromService(unit = CELSIUS_UNIT)

                }
            }
        }
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
        tvCity.text = city.toUpperCase()
        tvHumidity.text = getString(R.string.humidity, humidity)
    }

    private fun setupIconWeather() {
        val url = "http://openweathermap.org/img/w/$iconName.png"
        Picasso.with(this).load(url).into(ivWeather)
    }

    private fun setOnClickListener() {
        btnWholeDayForeCast.setOnClickListener {
            btnWholeDayForeCast.isClickable = false
            gotoForecastActivity()
        }
    }

    private fun gotoForecastActivity() {
        startActivity(Intent(this, ForecastActivity::class.java))
    }

    private fun getCurrentWeatherFromService(unit: String = Hawk.get(DEGREE_UNIT, DEFAULT_UNIT)) {
        currentWeatherPresenter.callServiceGetCurrentWeather(
                city = Hawk.get(CITY),
                unit = unit)
    }

    override fun updateCurrentWeather(response: CurrentWeatherResponseModel) {
        tvTemp.text = response.main?.temp.toString()
        tvDegree.text = AppUtil().getDegreeUnit(tvDegree)
        tvHumidity.text = response.main?.humidity.toString()
    }


    override fun getContext(): Context = this

    override fun displayDialog(message: String, firstButton: Int, block: (Any) -> Unit) {
        AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_btn_ok, { dialog, _ ->
                    dialog.dismiss()
                    btnWholeDayForeCast.isClickable = true
                })
                .show()
    }

}
