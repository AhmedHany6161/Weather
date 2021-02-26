package com.weatherintake41itiahy.weather.model.network

import android.content.Context
import com.weatherintake41itiahy.weather.model.room.OfflineDatabase
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkRequest private constructor() {

    companion object {
        @Volatile
        private var weatherServices: WeatherServices? = null
        fun getServices(): WeatherServices {
            return weatherServices ?: synchronized(this) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val service: WeatherServices = retrofit.create(WeatherServices::class.java)
                weatherServices = service
                service
            }
        }
    }
}