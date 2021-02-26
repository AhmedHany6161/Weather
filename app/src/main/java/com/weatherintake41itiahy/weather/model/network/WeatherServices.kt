package com.weatherintake41itiahy.weather.model.network

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface WeatherServices {
    @GET("onecall")
    suspend fun listRepos(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("dt") time: String,
        @Query("exclude") ex:String="hourly,daily",

        @Query("appid") id:String="6c55e902e38b6eaafb1e82b8e0a7d010"

    ): JsonObject

}