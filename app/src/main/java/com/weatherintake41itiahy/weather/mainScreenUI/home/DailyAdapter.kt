package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.screenData.WeatherFilterData
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily
import java.text.SimpleDateFormat
import java.util.*

class DailyAdapter : RecyclerView.Adapter<DailyAdapter.Holder>() {

    private var list: List<Daily>? = null

    fun setData(list: List<Daily>) {
        this.list = list
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val windSpeed: TextView = itemView.findViewById(R.id.dailyWind)
        private val image: ImageView = itemView.findViewById(R.id.dailyImageState)
        private val tempMin: TextView = itemView.findViewById(R.id.MinTemp)
        private val tempMax: TextView = itemView.findViewById(R.id.MaxTemp)
        private val main: TextView = itemView.findViewById(R.id.dailyMain)
        private val clouds: TextView = itemView.findViewById(R.id.dailyCloud)
        private val time: TextView = itemView.findViewById(R.id.dailyTime)
        private val hum: TextView = itemView.findViewById(R.id.dailyHumidity)
        private val press: TextView = itemView.findViewById(R.id.dailyPress)
        private val parent: LinearLayout = itemView.findViewById(R.id.daily_parent)

        private var imageId: Int = 0
        fun bind(currentWeather: Daily, context: Context) {
            parent.animation = AnimationUtils.loadAnimation(context, R.anim.recycler_anime_up_down)
            val filter = WeatherFilterData(context)
            imageId = filter.getImageStateDaily(currentWeather)
            val simpleTime = SimpleDateFormat("dd/ MMMM \nEEEE", Locale.getDefault())
            time.text = simpleTime.format(Date(currentWeather.date))
            windSpeed.text = " ${currentWeather.wind_speed}m/s"
            image.setImageResource(imageId)
            tempMin.text = filter.getTemp(currentWeather.tempMin)
            tempMax.text = filter.getTemp(currentWeather.tempMax)
            main.text = currentWeather.weatherMain
            clouds.text = " ${currentWeather.clouds}%"
            hum.text = " ${currentWeather.humidity}%"
            press.text = " ${currentWeather.pressure}hPa"
        }
    }

    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.daily_co, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list!![position], context!!)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}