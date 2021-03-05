package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.app.Application

import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.repository.Repository
import com.weatherintake41itiahy.weather.screenData.MainFeatures
import kotlinx.coroutines.*


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository(application)
    private val liveData: LiveData<WeatherEntity> = repository.geHomeWeather().asLiveData()
    private val job = Job()
    private val mainFeaturesLive: MutableLiveData<MainFeatures> = MutableLiveData()
    private var list: List<Hourly>? = null
    private var weatherEntity: WeatherEntity? = null
    private var visibility = false
    private val showAndHideDailyLive: MutableLiveData<Boolean> = MutableLiveData()

    private val observer = Observer<WeatherEntity> {
        if (it != null) {
            weatherEntity = it
            list = it.listOfHourly
        }
    }

    fun showAndHideDaily() {
        visibility = !visibility
        showAndHideDailyLive.postValue(visibility)
    }

    fun getDailyVisibilityOfList():LiveData<Boolean>{
        return showAndHideDailyLive
    }

    init {
        liveData.observeForever(observer)
        CoroutineScope(Dispatchers.Default + job).launch {

            var current: Long
            var currentWeather: Hourly? = null
            var hour=0
            while (job.isActive) {
                delay(2000)
                if (list != null) {
                    current = System.currentTimeMillis()
                    for (i in 0..47) {
                        hour=i
                        if (current < (list!![i].time + 3600000)) {
                            currentWeather = list!![i]
                            break
                        }
                    }
                    if(hour>1){
                        val latLng=weatherEntity!!.latLng.split(",")
                        repository.updateWeatherData(lat = latLng[0],lon = latLng[1],weatherEntity!!.city,true)
                    }

                    if (currentWeather != null) {
                        mainFeaturesLive.postValue(
                            MainFeatures(
                                currentWeather,
                                weatherEntity!!,
                                current
                            )
                        )
                    }else{
                        mainFeaturesLive.postValue(
                            MainFeatures(
                                list!![47],
                                weatherEntity!!,
                                current,
                                true
                            )
                        )
                    }
                    currentWeather = null

                }else{
                    mainFeaturesLive.postValue(null)
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