package com.hallelujah.daily.weather.main

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.util.AppUtil
import com.hallelujah.daily.weather.currentWeather.CurrentWeatherActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var mainPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickButton()
        setOnDoneAction()
        AppUtil.showSoftKeyboard(etCity)
    }

    private fun setOnClickButton() {
        btnCurrentWeather.setOnClickListener {
            mainPresenter.callServiceGetCurrentWeather(
                    city = etCity.text.toString(),
                    unit = DEFAULT_UNIT)
        }
    }

    override fun gotoCurrentWeatherActivity() {
        startActivity(Intent(this, CurrentWeatherActivity::class.java))
    }

    private fun setOnDoneAction() {
        etCity.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                visibleButtonGetCurrentWeather()
                AppUtil.hideSoftKeyboard(etCity)
                return@setOnEditorActionListener true
            } else {
                return@setOnEditorActionListener false
            }
        }
    }

    private fun visibleButtonGetCurrentWeather() {
        btnCurrentWeather.text = getString(R.string.btn_current_weather, etCity.text)
        btnCurrentWeather.visibility = View.VISIBLE
    }

    override fun getContext() = this

    override fun displayDialog(message: String, firstButton: Int, block: (Any) -> Unit) {
        AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(message)
                .setPositiveButton(R.string.dialog_btn_ok, { dialog, _ ->
                    dialog.dismiss()
                })
                .show()
    }
}

