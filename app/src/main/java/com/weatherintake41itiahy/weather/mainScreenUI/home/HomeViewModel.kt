package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.app.Application

import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.repository.Repository
import com.weatherintake41itiahy.weather.screenDataObj.MainFeatures
import kotlinx.coroutines.*
import java.text.SimpleDateFormat
import java.util.*


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(application)
    private val liveData: LiveData<WeatherEntity> = repository.geHomeWeather().asLiveData()
    private val job = Job()
    private val mainFeaturesLive: MutableLiveData<MainFeatures> = MutableLiveData()
    private var list: List<Hourly>? = null
    var weatherEntity: WeatherEntity? = null
    private val observer = Observer<WeatherEntity> {
        weatherEntity = it
        list = it.listOfHourly
    }

    init {
        repository.updateWeatherData("30.5965", "32.2715", "ismailia", true)
        liveData.observeForever(observer)
        CoroutineScope(Dispatchers.Default + job).launch {

            var current: Long
            var currentWeather: Hourly? = null
            while (job.isActive) {

                if (list != null) {
                    current = System.currentTimeMillis()
                    for (i in 0..47) {
                        if (current <= list!![i].time) {
                            currentWeather = list!![i]
                            break
                        }
                    }
                    if (currentWeather != null) {
                        mainFeaturesLive.postValue(
                            MainFeatures(
                                currentWeather,
                                weatherEntity!!,
                                current
                            )
                        )
                    }
                    currentWeather = null
                    delay(3000)
                }
            }

        }
    }


    fun getMainFeatures(): LiveData<MainFeatures> {
        return mainFeaturesLive
    }

    fun getWeather(): LiveData<WeatherEntity> {
        return liveData
    }

    override fun onCleared() {
        liveData.removeObserver(observer)
        job.cancel()
        super.onCleared()
    }


}