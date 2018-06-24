package com.hallelujah.daily.weather.forecast

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.hallelujah.daily.weather.PATTERN_SMALL_DATE
import com.hallelujah.daily.weather.PATTERN_TIME
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.model.ItemForecast
import com.hallelujah.daily.weather.core.util.AppUtil
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_forecast.view.*
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun setItemData(data: ItemForecast) {
        setText(data)
        setDescription(data)
        setIconWeather(data)
    }

    private fun setText(data: ItemForecast) {
        itemView.tvTime.text = AppUtil.getDateFormat(data.dtTxt ?: "", PATTERN_TIME)
        itemView.tvHumidity.text = itemView.context.getString(R.string.humidity, data.main?.humidity.toString())
        itemView.tvTemp.text = data.main?.temp.toString()
        itemView.tvDegree.text = AppUtil().getDegreeUnit(itemView)
        itemView.tvDateSmall.text = AppUtil.getDateFormat(data.dtTxt ?: "", PATTERN_SMALL_DATE)
    }

    private fun setDescription(data: ItemForecast) {
        val weather = data.weather
        weather?.let {
            if (it.isNotEmpty())
                itemView.tvDesc.text = data.weather[0]?.description
        }
    }

    private fun setIconWeather(data: ItemForecast) {
        var iconName = ""
        val weather = data.weather
        weather?.let {
            if (it.isNotEmpty())
                iconName = data.weather[0]?.icon ?: ""
        }
        val url = "http://openweathermap.org/img/w/$iconName.png"
        Picasso.with(itemView.context).load(url).into(itemView.iconWeather)
    }

}
