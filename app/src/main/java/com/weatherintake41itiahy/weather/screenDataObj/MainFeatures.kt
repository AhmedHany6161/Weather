package com.weatherintake41itiahy.weather.screenDataObj

data class MainFeatures(
    val imageId: Int,
    val city:String,
    val disc:String,
    val time:String,
    val date:String,
    val feels_like: Int,
    val pressure: Int,
    val humidity: Int,
    val clouds: Int,
    val visibility: Int,
    val windSpeed: Float
)