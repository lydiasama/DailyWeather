package com.hallelujah.daily.weather.main

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private var mainPresenter = MainPresenter(this)

    companion object {
        const val SHOW_KEYBOARD = "SHOW"
        const val HIDE_KEYBOARD = "HIDE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickButton()
        setOnDoneAction()
        keyboardManager(SHOW_KEYBOARD)
    }

    private fun setOnClickButton() {
        btnCurrentWeather.setOnClickListener {
            mainPresenter.callServiceGetCurrentWeather(
                    city = etCity.text.toString(),
                    unit = DEFAULT_UNIT)
        }
    }

    override fun gotoWeatherActivity() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun setOnDoneAction() {
        etCity.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                visibleButtonGetCurrentWeather()
                keyboardManager(HIDE_KEYBOARD)
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

    private fun keyboardManager(command: String) {
        val view: View = if (currentFocus == null) View(this) else currentFocus
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        when (command) {
            SHOW_KEYBOARD -> {
                etCity.requestFocus()
                inputMethodManager.showSoftInput(etCity, InputMethodManager.SHOW_FORCED)
            }
            else -> inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        }

    }
}

