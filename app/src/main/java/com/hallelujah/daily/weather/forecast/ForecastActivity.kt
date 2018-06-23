package com.hallelujah.daily.weather.forecast

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.R
import com.orhanobut.hawk.Hawk

class ForecastActivity : AppCompatActivity(), ForecastView {

    private var forecastPresenter = ForecastPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        forecastPresenter.callServiceGetForcast(
                city = Hawk.get(CITY),
                unit = DEFAULT_UNIT
        )
    }

    override fun gotoAllDayForcast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun displayDialog(message: String, firstButton: Int, block: (Any) -> Unit) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
