package com.weatherintake41itiahy.weather.mainScreenUI.mainActivity

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.weatherintake41itiahy.weather.work.WorkProcess


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val pref = PreferenceManager.getDefaultSharedPreferences(application)
    private val listener: SharedPreferences.OnSharedPreferenceChangeListener
    private val livePref: MutableLiveData<String> = MutableLiveData()

    init {
        listener =
            SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
                if (key.equals("home_location")) {
                    livePref.value =
                        sharedPreferences?.getString("home_location", "Select Manually")
                }
            }


        pref.registerOnSharedPreferenceChangeListener(listener)
    }

    fun upDateHomeWeather(latitude: String, longitude: String) {
        WorkProcess.getInstance(application = getApplication())
            .updateWeatherData(latitude = latitude, longitude = longitude, city = null, true)
    }

    fun upDateFavWeather(latitude: String, longitude: String) {
        WorkProcess.getInstance(application = getApplication())
            .updateWeatherData(latitude = latitude, longitude = longitude, city = null, false)
    }

    fun closeGPS() {
        pref.edit().putString("home_location", "Select Manually").apply()
    }

    fun isOpenGPS(): Boolean {
        return pref.getString("home_location", "Select Manually") == "GPS"
    }

    override fun onCleared() {
        super.onCleared()
        pref.unregisterOnSharedPreferenceChangeListener(listener)
    }

    fun getLivePref(): LiveData<String> {
        return livePref
    }

}