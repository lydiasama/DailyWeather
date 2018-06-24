package com.hallelujah.daily.weather.core.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.hallelujah.daily.weather.CELSIUS_UNIT
import com.hallelujah.daily.weather.DEFAULT_UNIT
import com.hallelujah.daily.weather.DEGREE_UNIT
import com.hallelujah.daily.weather.R
import com.orhanobut.hawk.Hawk
import org.joda.time.Days
import org.joda.time.LocalDate
import java.util.*

class AppUtil {

    companion object {

        @JvmStatic
        fun showSoftKeyboard(view: View) {
            if (view is EditText) {
                val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
            }
        }

        @JvmStatic
        fun hideSoftKeyboard(view: View) {
            if (view is EditText) {
                val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
                view.clearFocus()
            }
        }

        @JvmStatic
        fun getLocalDate(): String = LocalDate().toString("dd MMM yyyy", Locale.US)

        @JvmStatic
        fun getDifferentBetweenDate(startDate: LocalDate, endDate: LocalDate): Int {
            return Days.daysBetween(startDate, endDate).days
        }


    }

    fun getDegreeUnit(view: View): String {
        return when (Hawk.get(DEGREE_UNIT, DEFAULT_UNIT)) {
            CELSIUS_UNIT -> view.context.getString(R.string.degree_celsius)
            else -> view.context.getString(R.string.degree_fahrenheit)
        }
    }
}