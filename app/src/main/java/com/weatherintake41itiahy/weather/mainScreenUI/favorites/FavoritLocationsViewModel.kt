package com.weatherintake41itiahy.weather.mainScreenUI.favorites

import android.app.Application
import androidx.lifecycle.*
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.repository.Repository

class FavoritLocationsViewModel(application: Application) : AndroidViewModel(application) {
    val repository: Repository = Repository.getInstance(application)
    private val liveData: LiveData<List<WeatherEntity>> =
        repository.getFavoriteLocations().asLiveData()

    fun getFavorites(): LiveData<List<WeatherEntity>> {
        return liveData
    }
}