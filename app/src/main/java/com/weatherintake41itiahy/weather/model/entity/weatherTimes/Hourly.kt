package com.weatherintake41itiahy.weather.model.entity.weatherTimes

data class Hourly(
    val time: Long,
    val temp: Int,
    val feels_like: Int,
    val pressure: Int,
    val humidity: Int,
    val clouds: Int,
    val visibility: Int,
    val windSpeed: Float,
    val windDeg: Int,
    val weatherMain  : String,
    val weatherDescription  : String
)