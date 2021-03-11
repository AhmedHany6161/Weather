package com.weatherintake41itiahy.weather.work

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.util.Log
import android.view.View
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.preference.PreferenceManager
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import ca.antonious.materialdaypicker.MaterialDayPicker
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.HashSet

class WeatherAlertWork(val context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {
    private val mapOfWeather: HashMap<String, WeatherEntity> = HashMap()
    private val repository = Repository.getInstance(application = applicationContext as Application)
    private val pref = PreferenceManager.getDefaultSharedPreferences(context)
    private val calender: Calendar = Calendar.getInstance()
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            Log.e("tttttt", "uuuuuu")
            createNotificationChannel()
            var id = 3
            var weather: WeatherEntity?
            val day = calender.get(Calendar.DAY_OF_WEEK)
            for (entity in repository.getAllAlertsValue()) {
                if (entity.notify) {
                    if (!mapOfWeather.containsKey(entity.city)) {
                        weather = repository.getWeatherById(entity.city)
                        if (isConnected()) {
                            val latLng = weather.latLng.split(",")
                            repository.updateWeatherData(
                                lat = latLng[0],
                                lon = latLng[1],
                                weather.city,
                                weather.isTheCurrent
                            )
                            weather = repository.getWeatherById(entity.city)
                        }
                        mapOfWeather[entity.city] = weather
                    } else {
                        weather = mapOfWeather[entity.city]
                    }
                    if (day == 1 && entity.listDays.contains(MaterialDayPicker.Weekday.SUNDAY.name)
                        || (day == 2 && entity.listDays.contains(MaterialDayPicker.Weekday.MONDAY.name))
                        || (day == 3 && entity.listDays.contains(MaterialDayPicker.Weekday.TUESDAY.name))
                        || (day == 4 && entity.listDays.contains(MaterialDayPicker.Weekday.WEDNESDAY.name))
                        || (day == 5 && entity.listDays.contains(MaterialDayPicker.Weekday.THURSDAY.name))
                        || (day == 6 && entity.listDays.contains(MaterialDayPicker.Weekday.FRIDAY.name))
                        || (day == 7 && entity.listDays.contains(MaterialDayPicker.Weekday.SATURDAY.name))
                    ) {
                        if (filter(entity, weather!!)) {
                            val builder = NotificationCompat.Builder(context, "55")
                            when {
                                pref.getString("Alert_sound", "Alert sound") == "Alert sound" -> {
                                    builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                                }
                                pref.getString(
                                    "Alert_sound",
                                    "notification sound"
                                ) == "Alert sound" -> {
                                    builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                                }
                                else -> {
                                    builder.setDefaults(Notification.DEFAULT_ALL)
                                }
                            }
                            builder.setSmallIcon(R.drawable.cloud)
                                .setContentTitle("Weather alert")
                                .setContentText(entity.weatherState)
                                .setAutoCancel(true)
                                .setStyle(
                                    NotificationCompat.BigTextStyle()
                                        .bigText(entity.desc)
                                ).priority = NotificationCompat.PRIORITY_HIGH
                            with(NotificationManagerCompat.from(context)) {
                                notify(id, builder.build())
                            }
                            id++
                        }
                    }

                }
            }
            return@withContext Result.success()
        }

    }

    private fun filter(
        alertEntity: AlertEntity,
        weatherEntity: WeatherEntity
    ): Boolean {
        val hourly = weatherEntity.listOfHourly
        val start = getStart(hourly, alertEntity.from)
        for (i in start..(start + alertEntity.duration).coerceAtMost(hourly.size - 1))
            when (alertEntity.weatherState) {
                "cloud" -> {
                    return if (alertEntity.more) {
                        hourly[i].clouds >= alertEntity.unitCount
                    } else {
                        hourly[i].clouds < alertEntity.unitCount
                    }

                }

                "temp" -> {
                    return if (alertEntity.more) {
                        hourly[i].temp >= alertEntity.unitCount
                    } else {
                        hourly[i].temp < alertEntity.unitCount
                    }
                }
                "wind" -> {
                    return if (alertEntity.more) {
                        hourly[i].windSpeed >= alertEntity.unitCount
                    } else {
                        hourly[i].windSpeed < alertEntity.unitCount
                    }
                }
                else -> {
                   return alertEntity.weatherState.contains(hourly[i].weatherMain)
                }
            }

        return false
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                }
            }
        } else {
            try {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            } catch (e: Exception) {
                Log.i("update_statut", "" + e.message)
            }
        }
        return false
    }

    private fun createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "notification"
            val descriptionText = "start alert"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel("55", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }


    private fun getStart(hourly: List<Hourly>, from: Int): Int {
        var start: Int
        for ((i, h) in hourly.withIndex()) {
            calender.timeInMillis = h.time
            start = calender.get(Calendar.HOUR_OF_DAY)
            if (start >= from) {
                return i
            }
        }
        return hourly.size
    }

}