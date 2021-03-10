package com.weatherintake41itiahy.weather.alert.cityPicker

import android.app.Application
import androidx.lifecycle.*
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.repository.Repository

class CityPickerViewModel (application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository.getInstance(application)
    private var openFav: MutableLiveData<WeatherEntity> = MutableLiveData()
    private val liveData: LiveData<List<WeatherEntity>> =
        repository.getAllWeather().asLiveData()

    fun getData(): LiveData<List<WeatherEntity>> {
        return liveData
    }

    fun onPassData(weatherEntity: WeatherEntity) {
        openFav.value = weatherEntity
    }

    fun reset(){
        openFav.value=null
    }

    fun getObjectIntent(): LiveData<WeatherEntity> {
        return openFav
    }
}