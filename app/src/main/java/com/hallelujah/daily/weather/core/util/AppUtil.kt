package com.hallelujah.daily.weather.core.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

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
    }
}