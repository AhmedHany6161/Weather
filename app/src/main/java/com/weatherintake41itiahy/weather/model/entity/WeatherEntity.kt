package com.weatherintake41itiahy.weather.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.android.gms.maps.model.LatLng
import com.weatherintake41itiahy.weather.model.entity.converters.DailyConverter
import com.weatherintake41itiahy.weather.model.entity.converters.HourlyConverter
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.io.Serializable


@Entity
@TypeConverters(HourlyConverter::class, DailyConverter::class)
data class WeatherEntity (
    @PrimaryKey
    val city: String,
    val latLng: String,
    val sunrise: Long,
    val sunset: Long,
    val timeZone:String,
    val isTheCurrent: Boolean,
    val listOfHourly: List<Hourly>,
    val listOfDaily: List<Daily>
):Serializable