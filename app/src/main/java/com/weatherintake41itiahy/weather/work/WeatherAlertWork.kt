package com.weatherintake41itiahy.weather.work

import android.app.Application
import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class WeatherAlertWork(context: Context, params: WorkerParameters) :
    CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
//        val repository = Repository.getInstance(application = applicationContext as Application)
//        return withContext(Dispatchers.IO) {
//            val lat = inputData.getString("lat")!!
//            val lon = inputData.getString("lon")!!
//            var city: String? = inputData.getString("city")
//            val isHome = inputData.getBoolean("isHome", false)
//            if (city == null) {
//                city = getCity(lat.toDouble(), lon.toDouble())
//            }
//            repository.updateWeatherData(lat = lat, lon = lon, city, isHome)
//            return@withContext Result.success()
//        }
        Log.e("ttttttt","ttttt")
        return Result.success()
    }


    private fun getCity(lat: Double, lon: Double): String {
        var city: String?
        val addresses: List<Address>
        val geoCoder = Geocoder(applicationContext, Locale.getDefault())
        addresses = geoCoder.getFromLocation(
            lat,
            lon,
            1
        )
        city = addresses[0].adminArea

        if (city == null) {
            city = addresses[0].countryName
        }
        if (city == null) {
            city = addresses[0].getAddressLine(0)
        }

        return city!!
    }
}