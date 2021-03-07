package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.app.Application

import androidx.lifecycle.*
import androidx.lifecycle.Observer
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly
import com.weatherintake41itiahy.weather.model.repository.Repository
import com.weatherintake41itiahy.weather.screenData.MainFeatures
import com.weatherintake41itiahy.weather.work.WorkProcess
import kotlinx.coroutines.*
import java.util.*


class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository.getInstance(application)
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
        showAndHideDailyLive.value = visibility
    }

    fun getDailyVisibilityOfList(): LiveData<Boolean> {
        return showAndHideDailyLive
    }

    init {
        liveData.observeForever(observer)
        CoroutineScope(Dispatchers.Default + job).launch {

            var current: Long
            var currentWeather: Hourly? = null
            var hour = 0
            while (job.isActive) {
                delay(2500)
                if (list != null) {
                    val calender = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                    current = calender.timeInMillis
                    for (i in 0..47) {
                        hour = i
                        if (current < (list!![i].time + 3600000)) {
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
                    } else {
                        mainFeaturesLive.postValue(
                            MainFeatures(
                                list!![47],
                                weatherEntity!!,
                                current,
                                true
                            )
                        )
                    }
                    if (hour > 24) {
                        val latLng = weatherEntity!!.latLng.split(",")
                        WorkProcess.getInstance(getApplication()).updateWeatherData(
                            latitude = latLng[0],
                            longitude = latLng[1],
                            weatherEntity!!.city,
                            true
                        )

                    }
                    currentWeather = null

                } else {
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