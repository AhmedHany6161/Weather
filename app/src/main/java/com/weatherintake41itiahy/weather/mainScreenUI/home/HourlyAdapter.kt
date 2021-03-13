package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.Local.LocalLang
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.screenData.WeatherFilterData
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.text.SimpleDateFormat
import java.util.*

class HourlyAdapter : RecyclerView.Adapter<HourlyAdapter.Holder>() {

    private var list: List<Hourly>? = null
    private var sunrise: Long? = null
    private var sunset: Long? = null
    private var timeZone:TimeZone?=null
    private val calender= Calendar.getInstance(TimeZone.getTimeZone("UTC"))

    fun setData(timeZone: TimeZone,sunrise: Long, sunset: Long, list: List<Hourly>) {
        this.sunrise = sunrise
        this.sunset = sunset
        this.list = list
        this.timeZone=timeZone
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val windSpeed: TextView = itemView.findViewById(R.id.windSpeedHourRec)
        private val image: ImageView = itemView.findViewById(R.id.imageHourRec)
        private val temp: TextView = itemView.findViewById(R.id.tempHourRec)
        private val time: TextView = itemView.findViewById(R.id.timeHourRec)
        private val main: TextView = itemView.findViewById(R.id.main_temp_rec)
        private val clouds: TextView = itemView.findViewById(R.id.clouds_rec_id)
        private val parent: LinearLayout = itemView.findViewById(R.id.holder_hourly)
        private var imageId: Int = 0

        fun bind(calender:Calendar,timeZone: TimeZone,currentWeather: Hourly, sunrise: Long, sunset: Long, context: Context) {
            val filter = WeatherFilterData(context)
            calender.timeInMillis=currentWeather.time
            val cDate = calender.time
            val simpleTime = SimpleDateFormat("EEE / h a", Locale.getDefault())
            simpleTime.timeZone = timeZone
            imageId = filter.getImageStateHourly(calender,currentWeather, sunrise, sunset)
            windSpeed.text = filter.getSpeedUnit(currentWeather.windSpeed)
            image.setImageResource(imageId)
            time.text = simpleTime.format(cDate)
            temp.text = filter.getTemp(currentWeather.temp)
            main.text = context.getText(LocalLang.getMainWeatherSate(currentWeather.weatherMain))
            clouds.text = " ${currentWeather.clouds}%"
            parent.animation =
                AnimationUtils.loadAnimation(context, R.anim.recycler_anime_up_down)
        }
    }

    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.hourly_co, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(calender,timeZone!!,list!![position], sunrise!!, sunset!!, context!!)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}