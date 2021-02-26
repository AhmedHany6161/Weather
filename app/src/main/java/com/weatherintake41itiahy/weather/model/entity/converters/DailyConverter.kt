package com.weatherintake41itiahy.weather.model.entity.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily

class DailyConverter {

    companion object {
        @JvmStatic
        @TypeConverter
        fun dailyToString(value: String): List<Daily> {
            val listType = object : TypeToken<List<Daily>>() {}.type
            return Gson().fromJson(value, listType)
        }

        @JvmStatic
        @TypeConverter
        fun stringToDaily(list: List<Daily>): String {
            return Gson().toJson(list)
        }
    }
}