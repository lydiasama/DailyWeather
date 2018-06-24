package com.hallelujah.daily.weather.forecast

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.FORECAST_DAY
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.model.ItemForecast
import com.hallelujah.daily.weather.core.util.AppUtil
import com.hallelujah.daily.weather.core.util.AppUtil.Companion.getLocalDate
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_forecast.*
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import java.util.*

class ForecastActivity : AppCompatActivity(), ForecastView {

    private var forecastPresenter = ForecastPresenter(this)
    var adapter = ForecastAdapter(this, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        initRecyclerView()
        getForcastFromService()
        setupView()
    }

    private fun getForcastFromService(unit: String = DEFAULT_UNIT) {
        forecastPresenter.callServiceGetForcast(
                city = Hawk.get(CITY),
                unit = unit
        )
    }

    private fun setupView() {
        tvDate.text = getLocalDate()
        val city: String = Hawk.get(CITY)
        tvTitleForecast.text = getString(R.string.forecast_title, city.toUpperCase())
    }

    override fun displayAllDayForcast(list: ArrayList<ItemForecast>) {
        list.filter {
            getDifferentBetweenDate(it.dtTxt ?: "") < FORECAST_DAY
        }
        list.forEach {
            it.dtTxt = getTimeOnly(it.dtTxt ?: "")
        }
        adapter.setItemList(list)
    }

    private fun getDifferentBetweenDate(dateResponse: String): Int {
        val formatOfResponse = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
        val dateResponseWithFormat = formatOfResponse.parseDateTime(dateResponse)
        val newFormatOutput = DateTimeFormat.forPattern("dd MMM YYYY")
        println(newFormatOutput.print(dateResponseWithFormat))

        return AppUtil.getDifferentBetweenDate(LocalDate(), LocalDate(dateResponseWithFormat))
    }

    private fun getTimeOnly(dateTime: String): String {
        val formatOfResponse = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")
        val dateResponseWithFormat = formatOfResponse.parseDateTime(dateTime)
        val newFormatOutput = DateTimeFormat.forPattern("HH:mm:ss")
        return newFormatOutput.print(dateResponseWithFormat)
    }

    override fun getContext(): Context = this

    override fun displayDialog(message: String, firstButton: Int, block: (Any) -> Unit) {
        AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_btn_ok, { dialog, _ ->
                    dialog.dismiss()
                })
                .show()
    }

    private fun initRecyclerView() {
        adapter = ForecastAdapter(this, arrayListOf())
        recyclerForecast.layoutManager = android.support.v7.widget.LinearLayoutManager(this)
        recyclerForecast.isNestedScrollingEnabled = false
        recyclerForecast.setHasFixedSize(true)
        recyclerForecast.adapter = adapter
    }
}
