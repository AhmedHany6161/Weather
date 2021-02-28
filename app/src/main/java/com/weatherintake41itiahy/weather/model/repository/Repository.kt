package com.weatherintake41itiahy.weather.model.repository

import android.app.Application
import android.util.Log
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.network.NetworkRequest
import com.weatherintake41itiahy.weather.model.network.WeatherServices
import com.weatherintake41itiahy.weather.model.room.OfflineDatabase
import com.weatherintake41itiahy.weather.model.room.WeatherDAO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.lang.Exception


class Repository(application: Application) {
    private val tag = Repository::class.simpleName
    private val weatherDAO: WeatherDAO = OfflineDatabase.getDatabase(application).WeatherDAO()
    private val services: WeatherServices = NetworkRequest.getServices()

    fun updateWeatherData(
        lat: String,
        lon: String,
        time: Long,
        city: String,
        home: Boolean
    ) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val call = services.listRepos(lat, lon, "$time")
                Log.e("asasa", call.get("timezone").toString())
                weatherDAO.setWeather(
                    WeatherEntity(
                        city,
                        "$lat,$lon",
                        call.getAsJsonObject("current").get("sunrise").asLong,
                        call.getAsJsonObject("current").get("sunset").asLong,
                        home,
                        convertToHourlyList(call.getAsJsonArray("hourly"),call.get("timezone_offset").asLong),
                        convertToDailyList(call.getAsJsonArray("daily"))
                    )
                )
            } catch (e: Exception) {
                Log.e(tag, e.toString())
            }


        }
    }

    fun geHomeWeather(): Flow<WeatherEntity> {
        return weatherDAO.getCurrentWeather()
    }

    fun getFavoriteLocations(): Flow<List<WeatherEntity>> {
        return weatherDAO.getFavoriteWeather()
    }

    fun deleteItem(weatherEntity: WeatherEntity) {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDAO.delete(weatherEntity)
        }
    }

    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            weatherDAO.deleteAll()
        }
    }

    private fun convertToDailyList(jsonArray: JsonArray): List<Daily> {
        var jsonObject: JsonObject

        return List(jsonArray.size()) { index ->
            jsonObject = jsonArray.get(index).asJsonObject
            Daily(
                jsonObject.get("dt").asLong,
                jsonObject.get("sunrise").asLong,
                jsonObject.get("sunset").asLong,
                jsonObject.getAsJsonObject("temp").get("min").asInt,
                jsonObject.getAsJsonObject("temp").get("max").asInt,
                jsonObject.getAsJsonObject("feels_like").get("day").asInt,
                jsonObject.get("pressure").asInt,
                jsonObject.get("humidity").asInt,
                jsonObject.get("clouds").asInt,
                jsonObject.get("wind_speed").asFloat,
                jsonObject.get("wind_deg").asInt,
                jsonObject.getAsJsonArray("weather").get(0).asJsonObject.get("main").asString,
                jsonObject.getAsJsonArray("weather").get(0).asJsonObject.get("description").asString
            )
        }
    }

    private fun convertToHourlyList(jsonArray: JsonArray,offset:Long): List<Hourly> {
        var jsonObject: JsonObject

        return List(jsonArray.size()) { index ->
            jsonObject = jsonArray.get(index).asJsonObject
            Hourly(
                ((jsonObject.get("dt").asLong+offset)*1000L),
                jsonObject.get("temp").asInt,
                jsonObject.get("feels_like").asInt,
                jsonObject.get("pressure").asInt,
                jsonObject.get("humidity").asInt,
                jsonObject.get("clouds").asInt,
                jsonObject.get("visibility").asInt,
                jsonObject.get("wind_speed").asFloat,
                jsonObject.get("wind_deg").asInt,
                jsonObject.getAsJsonArray("weather").get(0).asJsonObject.get("main").asString,
                jsonObject.getAsJsonArray("weather").get(0).asJsonObject.get("description").asString
            )
        }
    }
}