package com.weatherintake41itiahy.weather.screenData

import android.content.Context
import android.util.Log
import androidx.preference.PreferenceManager
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.util.*

class WeatherFilterData( val context: Context) {
    private val preference = PreferenceManager.getDefaultSharedPreferences(context)
    private val degreeUnit = preference.getString("temp_unit", "Celsius")
    private val speedUnit = preference.getString("wind_speed", "meter/sec")
    fun getTemp(temp: Int): String {
        return when {
            degreeUnit.equals("Celsius") -> {
                "${temp}°c"
            }
            degreeUnit.equals("kelvin") -> {
                "${(temp + 273.1)}°k"
            }
            else -> {
                "${String.format("%.1f", ((temp + 32f) / (5f / 9f)))}°f"
            }
        }
    }

    fun getSpeed(speed: Double) {

    }

    fun getImageStateHourly(
        currentWeather: Hourly,
        sunrise: Long ,
        sunset: Long
    ): Int {
        if (currentWeather.weatherMain.equals("Thunderstorm")) {
            return R.drawable.thunder_46
        } else if (currentWeather.weatherMain.equals("Drizzle") ||
            currentWeather.weatherMain.equals("Snow")
            || currentWeather.weatherMain.equals("Rain")
        ) {
            return R.drawable.rain_f_46

        } else {
            val calendar = Calendar.getInstance()
            Log.e("asasas", "$sunrise $sunset")
            calendar.timeInMillis = currentWeather.time
            val cur = calendar.get(Calendar.HOUR_OF_DAY)
            calendar.timeInMillis = sunrise
            val res = calendar.get(Calendar.HOUR_OF_DAY)
            calendar.timeInMillis = sunset
            val set = calendar.get(Calendar.HOUR_OF_DAY)
            return if (cur in res..set) {
                if (currentWeather.weatherMain.equals("Clear")) {
                    R.drawable.sunny_fff_46_
                } else {
                    R.drawable.cloud_46

                }
            } else {
                if (currentWeather.weatherMain.equals("Clear")) {
                    R.drawable.moon_46
                } else {
                    R.drawable.cloud_46

                }
            }
        }
    }

    fun getImageStateDaily(
        currentWeather: Daily,

    ): Int {
        if (currentWeather.weatherMain.equals("Thunderstorm")) {
            return R.drawable.thunder_46
        } else if (currentWeather.weatherMain.equals("Drizzle") ||
            currentWeather.weatherMain.equals("Snow")
            || currentWeather.weatherMain.equals("Rain")
        ) {
            return R.drawable.rain_f_46

        } else {

            return if (currentWeather.weatherMain.equals("Clear")) {
                R.drawable.sunny_fff_46_
            } else {
                R.drawable.cloud_46
            }
        }
    }
}