package com.weatherintake41itiahy.weather.work

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.ContentResolver
import android.content.Context
import android.media.RingtoneManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.preference.PreferenceManager
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import ca.antonious.materialdaypicker.MaterialDayPicker
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.HashMap


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
                            val builder = NotificationCompat.Builder(
                                context,
                                pref.getString("Alert_sound", "Alert sound")!!
                            )
                            val sound =
                                Uri.parse(
                                    ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                                            context.packageName + "/" + R.raw.alert
                                )
                            when (pref.getString("Alert_sound", "Alert sound")) {
                                "Alert sound" -> {
                                    builder.setSound(sound)
                                }
                                "notification sound" -> {
                                    builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE))
                                }

                            }
                            builder.setSmallIcon(R.drawable.cloud)
                                .setContentTitle("Weather alert")
                                .setContentText(entity.weatherState)
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
        val sound =
            Uri.parse(
                ContentResolver.SCHEME_ANDROID_RESOURCE + "://" +
                        context.packageName + "/" + R.raw.alert_2
            )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "notification"
            val descriptionText = "start alert"
            val importance = NotificationManager.IMPORTANCE_HIGH

            val channel = NotificationChannel(
                pref.getString("Alert_sound", "Alert sound")!!,
                name,
                importance
            ).apply {
                description = descriptionText

            }
            channel.enableVibration(true)
            when (pref.getString("Alert_sound", "Alert sound")) {
                "Alert sound" -> {
                    Log.e("sound", "alert")
                    channel.setSound(
                        sound,
                        channel.audioAttributes
                    )
                }
                "notification sound" -> {
                    Log.e("sound", "notification")

                    channel.setSound(
                        RingtoneManager.getDefaultUri(RingtoneManager.TYPE_RINGTONE),
                        channel.audioAttributes
                    )
                }

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