package com.weatherintake41itiahy.weather.model.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity

@Database(entities = [WeatherEntity::class, AlertEntity::class], version = 1 , exportSchema = false)
 abstract class OfflineDatabase : RoomDatabase() {
    abstract fun WeatherDAO(): WeatherDAO
    companion object {
        @Volatile
        private var INSTANCE: OfflineDatabase? = null
        fun getDatabase(application: Application): OfflineDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    application,
                    OfflineDatabase::class.java,
                    "Weather_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}