package com.weatherintake41itiahy.weather.mainScreenUI.mainActivity

import android.app.Application
import android.location.Address
import android.location.Geocoder
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(application)

    fun upDateHomeWeather(latitude: String, longitude: String) {
        val addresses: List<Address>
        val geoCoder = Geocoder(getApplication(), Locale.getDefault())
        addresses = geoCoder.getFromLocation(
            latitude.toDouble(),
            longitude.toDouble(),
            5
        )
        var city: String? = null
        var i = 0
        while (city == null && i < addresses.size) {
            city = addresses[i].locality
            i++
        }
        if (city == null) {
            val addressLine: String? = addresses[0].getAddressLine(0)
            if (addressLine != null) {
                city = addressLine
            } else {
                city = "unKnown"
            }
        }
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateWeatherData(
                latitude,
                longitude,
                city, true
            )
        }

    }

}