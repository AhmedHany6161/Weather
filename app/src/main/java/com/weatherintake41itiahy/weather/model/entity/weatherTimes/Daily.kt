package com.weatherintake41itiahy.weather.model.entity.weatherTimes

data class Daily(
    val date: Long,
    val sunrise : Long,
    val sunset : Long,
    val tempMin: Int,
    val tempMax: Int,
    val feels_like: Int,
    val pressure: Int,
    val humidity: Int,
    val clouds: Int,
    val wind_speed: Float,
    val wind_deg: Int,
    val weatherMain: String,
    val weatherDes: String
)
