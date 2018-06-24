package com.hallelujah.daily.weather.forecast

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.hallelujah.daily.weather.R
import com.hallelujah.daily.weather.core.model.ItemForecast

class ForecastAdapter(private val context: Context, private var item: ArrayList<ItemForecast>) : RecyclerView.Adapter<ForecastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val holder = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return ForecastViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        val weather = item[position]
        holder.setItemData(weather)
    }

    override fun getItemCount(): Int {
        return item.size
    }

    override fun getItemViewType(position: Int): Int {
        return 1
    }

    fun setItemList(list: ArrayList<ItemForecast>) {
        item.clear()
        item.addAll(list)
        notifyDataSetChanged()
    }
}