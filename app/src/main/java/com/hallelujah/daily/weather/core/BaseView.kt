package com.hallelujah.daily.weather.core

import android.content.Context
import android.support.annotation.StringRes
import com.hallelujah.daily.weather.R

interface BaseView {

    fun getContext(): Context

    fun displayDialog(message: String,
                      @StringRes firstButton: Int = R.string.dialog_btn_ok,
                      block: (Any) -> Unit = {})
}