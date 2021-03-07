package com.weatherintake41itiahy.weather.screenData

import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.text.SimpleDateFormat
import java.util.*

data class MainFeatures(
    private val currentWeather: Hourly,
    private val weatherEntity: WeatherEntity,
    private val current: Long,
    val outOfDate: Boolean = false
) {
    val imageId: Int
    val city: String
    val disc: String
    val timeZone: String
    val feelsLike: Int
    val pressure: Int
    val humidity: Int
    val clouds: Int
    val visibility: Int
    val temp: Int
    val windSpeed: Float
    val windDegree: Int

    init {

        if (currentWeather.weatherMain.equals("Thunderstorm")) {
            imageId = R.drawable.thander
        } else if (currentWeather.weatherMain.equals("Drizzle") ||
            currentWeather.weatherMain.equals("Snow")
            || currentWeather.weatherMain.equals("Rain")
        ) {
            imageId = R.drawable.rain_ani

        } else {
            val calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            calendar.timeInMillis = current
            val cur = calendar.get(Calendar.HOUR_OF_DAY)
            calendar.timeInMillis = weatherEntity.sunrise
            val res = calendar.get(Calendar.HOUR_OF_DAY)
            calendar.timeInMillis = weatherEntity.sunset
            val set = calendar.get(Calendar.HOUR_OF_DAY)
            imageId = if (cur in res..set) {
                if (currentWeather.weatherMain.equals("Clear")) {
                    R.drawable.sunny_anim

                } else {
                    R.drawable.cloud
                }
            } else {
                if (currentWeather.weatherMain.equals("Clear")) {
                    R.drawable.moon_night

                } else {
                    R.drawable.cloud
                }
            }
        }
        city = weatherEntity.city
        disc = currentWeather.weatherDescription
        timeZone =weatherEntity.timeZone
        feelsLike = currentWeather.feels_like
        pressure = currentWeather.pressure
        humidity = currentWeather.humidity
        clouds = currentWeather.clouds
        visibility = currentWeather.visibility
        windSpeed = currentWeather.windSpeed
        temp = currentWeather.temp
        windDegree = currentWeather.windDeg
    }


}



