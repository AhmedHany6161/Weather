package com.weatherintake41itiahy.weather.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.weatherintake41itiahy.weather.model.entity.converters.ListConverter
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import java.io.Serializable

@Entity
@TypeConverters(ListConverter::class)
data class AlertEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0,
    var city: String,
    var weatherState: String,
    var from: Int,
    var duration: Int,
    var desc: String,
    var listDays: List<String>,
    var more: Boolean,
    var notify: Boolean,
    var unitCount: Int
):Serializable