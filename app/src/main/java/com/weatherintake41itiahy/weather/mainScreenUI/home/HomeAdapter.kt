package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.text.SimpleDateFormat
import java.util.*

class HomeAdapter() : RecyclerView.Adapter<HomeAdapter.Holder>() {

    private var list: List<Hourly>? = null
    private var sunrise: Long? = null
    private var sunset: Long? = null
    fun setData(sunrise: Long, sunset: Long, list: List<Hourly>) {
        Log.e("asasa","$sunrise")
        this.sunrise = sunrise
        this.sunset = sunset
        this.list = list
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val windSpeed: TextView = itemView.findViewById(R.id.windSpeedHourRec)
        private val image: ImageView = itemView.findViewById(R.id.imageHourRec)
        private val temp: TextView = itemView.findViewById(R.id.tempHourRec)
        private val time: TextView = itemView.findViewById(R.id.timeHourRec)
        private val main: TextView = itemView.findViewById(R.id.main_temp_rec)
        private val clouds: TextView = itemView.findViewById(R.id.clouds_rec_id)

        private var imageId: Int = 0

        fun bind(currentWeather: Hourly,sunrise: Long, sunset: Long) {

            if (currentWeather.weatherMain.equals("Thunderstorm")) {
                imageId = R.drawable.thunder_46
            } else if (currentWeather.weatherMain.equals("Drizzle") ||
                currentWeather.weatherMain.equals("Snow")
                || currentWeather.weatherMain.equals("Rain")
            ) {
                imageId = R.drawable.rain_f_46

            } else {
                val calendar=Calendar.getInstance()
                Log.e("asasas","$sunrise $sunset")
                calendar.timeInMillis=currentWeather.time
                val cur =calendar.get(Calendar.HOUR_OF_DAY)
                calendar.timeInMillis=sunrise
                val res =calendar.get(Calendar.HOUR_OF_DAY)
                calendar.timeInMillis=sunset
                val set =calendar.get(Calendar.HOUR_OF_DAY)
                if (cur in res..set) {
                    imageId = if (currentWeather.weatherMain.equals("Clear")) {
                        R.drawable.sunny_fff_46_
                    } else {
                        R.drawable.cloud_46

                    }
                } else {
                    imageId = if (currentWeather.weatherMain.equals("Clear")) {
                        R.drawable.moon_46

                    } else {
                        R.drawable.cloud_46

                    }
                }
            }
            val cDate = Date(currentWeather.time)
            val simpleTime = SimpleDateFormat("EEE/h a", Locale.US)
            windSpeed.text = " ${currentWeather.windSpeed}m/s"
            image.setImageResource(imageId)
            time.text = simpleTime.format(cDate)
            temp.text="${currentWeather.temp}°C"
            main.text=currentWeather.weatherMain
            clouds.text=" ${currentWeather.clouds}%"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourly_co, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
       holder.bind(list!![position],sunrise!!,sunset!!)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}