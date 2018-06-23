package com.hallelujah.daily.weather.forecast

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.hallelujah.daily.weather.CITY
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.model.ItemForecast
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_forecast.*

class ForecastActivity : AppCompatActivity(), ForecastView {

    private var forecastPresenter = ForecastPresenter(this)
    var adapter = ForecastAdapter(this, arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)
        initRecyclerView()
        forecastPresenter.callServiceGetForcast(
                city = Hawk.get(CITY),
                unit = DEFAULT_UNIT
        )
    }

    override fun displayAllDayForcast(list: ArrayList<ItemForecast>) {
        list.filter {

        }
        adapter.setItemList(list)
    }

    override fun getContext(): Context {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

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
