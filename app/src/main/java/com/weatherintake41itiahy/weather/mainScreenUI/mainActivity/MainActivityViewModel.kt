package com.weatherintake41itiahy.weather.mainScreenUI.mainActivity

import android.app.Application
import android.content.SharedPreferences
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.preference.PreferenceManager
import com.weatherintake41itiahy.weather.work.WorkProcess


class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val pref = PreferenceManager.getDefaultSharedPreferences(application)
    private val listener: SharedPreferences.OnSharedPreferenceChangeListener
    private val livePrefLocation: MutableLiveData<String> = MutableLiveData()
    private val livePrefLang: MutableLiveData<String?> = MutableLiveData()

    init {
        listener =
            SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, key ->
                if (key.equals("home_location")) {
                    livePrefLocation.value =
                        sharedPreferences?.getString("home_location", "Select Manually")
                }else if(key.equals("language")){
                    livePrefLang.value=sharedPreferences?.getString("language", "en")
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

    fun getLivePrefLocation(): LiveData<String> {
        return livePrefLocation
    }

    fun getLang():String {
       return pref.getString("language","en")!!
    }
    fun getLivePrefLang():LiveData<String?>{
        return livePrefLang
    }
    fun resetLang(){
        livePrefLang.value=null
    }
}