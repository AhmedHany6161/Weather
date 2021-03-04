package com.weatherintake41itiahy.weather.model.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDAO {
    @Query("SELECT * FROM WeatherEntity where isTheCurrent=0")
    fun getFavoriteWeather(): Flow<List<WeatherEntity>>

    @Query("SELECT * FROM WeatherEntity where isTheCurrent=1")
    fun getHomeWeather(): Flow<WeatherEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setWeather(weather: WeatherEntity)

    @Delete
    suspend fun delete(weather: WeatherEntity)

    @Query("DELETE FROM WeatherEntity ")
    suspend fun deleteAll()
    @Query("DELETE FROM WeatherEntity where isTheCurrent=1")
    suspend fun deleteHome()
}