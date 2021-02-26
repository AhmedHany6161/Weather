package com.weatherintake41itiahy.weather.model.entity.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly

class HourlyConverter {
    companion object {
        @JvmStatic
        @TypeConverter
        fun convertToList(value: String): List<Hourly> {
            val listType = object : TypeToken<List<Hourly>>() {}.type
            return Gson().fromJson(value, listType)
        }

        @JvmStatic
        @TypeConverter
        fun convertToString(list: List<Hourly>): String {
            return Gson().toJson(list).toString()
        }

    }


}