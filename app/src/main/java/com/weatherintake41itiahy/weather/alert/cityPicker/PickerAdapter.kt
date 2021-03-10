package com.weatherintake41itiahy.weather.alert.cityPicker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.TextClock
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import java.util.*

class PickerAdapter(val viewModel: CityPickerViewModel): RecyclerView.Adapter<PickerAdapter.Holder>() {

    private var list: List<WeatherEntity>? = null

    fun setData(weatherEntity: List<WeatherEntity>) {
        list=weatherEntity
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.fav_rec_name)
        private val time: TextClock = itemView.findViewById(R.id.fav_rec_time)
        private val date: TextClock = itemView.findViewById(R.id.fav_rec_date)

        fun bind(currentWeather: WeatherEntity,context:Context,favoriteLocationsViewModel: CityPickerViewModel) {
            name.text = currentWeather.city
            time.timeZone = currentWeather.timeZone
            date.timeZone =  currentWeather.timeZone
            itemView.animation =
                AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_down)
            itemView.setOnClickListener {
                favoriteLocationsViewModel.onPassData(currentWeather)
            }
        }
    }

    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fav_co, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list!![position],context!!,viewModel)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}