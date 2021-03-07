package com.weatherintake41itiahy.weather.mainScreenUI.mainActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.weatherintake41itiahy.weather.work.WorkProcess

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    fun upDateHomeWeather(latitude: String, longitude: String) {
        WorkProcess.getInstance(application = getApplication())
            .updateWeatherData(latitude = latitude, longitude = longitude, city = null,true)
    }
    fun upDateFavWeather(latitude: String, longitude: String) {
        WorkProcess.getInstance(application = getApplication())
            .updateWeatherData(latitude = latitude, longitude = longitude, city = null,false)
    }
}