package com.weatherintake41itiahy.weather.mainScreenUI.favorites

import android.app.Application
import androidx.lifecycle.*
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritLocationsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository.getInstance(application)
    private var openFav: MutableLiveData<WeatherEntity> = MutableLiveData()
    private val liveData: LiveData<List<WeatherEntity>> =
        repository.getFavoriteLocations().asLiveData()

    fun getFavorites(): LiveData<List<WeatherEntity>> {
        return liveData
    }

    fun onPassData(weatherEntity: WeatherEntity) {
        openFav.value = weatherEntity
    }

    fun reset() {
        openFav.value = null
    }

    fun getFavObjectIntent(): LiveData<WeatherEntity> {
        return openFav
    }

    fun deleteItem(weatherEntity: WeatherEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteItem(weatherEntity)
        }
    }
}