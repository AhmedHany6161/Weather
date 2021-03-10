package com.weatherintake41itiahy.weather.work

import android.app.Application
import androidx.preference.PreferenceManager
import androidx.work.*
import java.util.concurrent.TimeUnit

class WorkProcess private constructor(application: Application) {
    private val workManager = WorkManager
        .getInstance(application)

    companion object {
        private var workProcess: WorkProcess? = null
        fun getInstance(application: Application): WorkProcess {
            if (workProcess == null) {
                workProcess = WorkProcess(application)
            }
            return workProcess!!
        }
    }

    fun updateWeatherData(latitude: String, longitude: String, city: String?, isHome: Boolean) {
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val data = Data.Builder()
        data.putString("lat", latitude)
        data.putString("lon", longitude)
        data.putBoolean("isHome", isHome)
        data.putString("city", city)

        val updateHome: OneTimeWorkRequest =
            OneTimeWorkRequestBuilder<UpdateWeatherWorker>()
                .setConstraints(constraints)
                .setInputData(data.build())
                .build()
        workManager.enqueueUniqueWork("updateHome", ExistingWorkPolicy.REPLACE, updateHome)
    }



    fun setAlert(initTime: Long,rep:Long) {
        val alertWork = PeriodicWorkRequestBuilder<WeatherAlertWork>(
            rep, TimeUnit.SECONDS,
        ).setInitialDelay(initTime, TimeUnit.MINUTES)
            .build()
        workManager.enqueueUniquePeriodicWork(
            "weather_alert",
            ExistingPeriodicWorkPolicy.REPLACE, alertWork
        )
    }

    fun cancelAlert() {
        workManager.cancelUniqueWork("weather_alert")
    }
}