package com.weatherintake41itiahy.weather.model.entity.converters

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily

class ListConverter {

    companion object {
        @JvmStatic
        @TypeConverter
        fun listToString(value: String): List<String> {
            val listType = object : TypeToken<List<String>>() {}.type
            return Gson().fromJson(value, listType)
        }

        @JvmStatic
        @TypeConverter
        fun stringToList(list: List<String>): String {
            return Gson().toJson(list)
        }
    }

}