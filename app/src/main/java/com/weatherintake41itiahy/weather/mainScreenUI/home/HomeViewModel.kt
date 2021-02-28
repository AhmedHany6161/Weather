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
    private val liveHourly: MutableLiveData<List<Hourly>> = MutableLiveData()
    private var list: List<Hourly>? = null
    private var weatherEntity: WeatherEntity? = null
    private val observer = Observer<WeatherEntity> {
        if (it != null) {
            weatherEntity = it
            list = it.listOfHourly
            liveHourly.postValue(list)
        }
    }

    init {

        liveData.observeForever(observer)
        CoroutineScope(Dispatchers.Default + job).launch {

            var current: Long
            var currentWeather: Hourly? = null
            var date: Date
            while (job.isActive) {
                current = System.currentTimeMillis()
                if (list != null) {
                    for (i in 0..47) {
                        if (current <= list!![i].time) {
                            currentWeather = list!![i]
                            break
                        }
                    }
                    if (currentWeather != null) {
                        date = Date(current)
                        val simpleTime = SimpleDateFormat("h:mm a", Locale.US)
                        val simpleDate = SimpleDateFormat("dd / EEE / MMM /yyyy", Locale.US)
                        if (currentWeather.weatherMain.equals("Thunderstorm")) {
                            mainFeaturesLive.postValue(
                                MainFeatures(
                                    R.drawable.thander,
                                    weatherEntity!!.city,
                                    currentWeather.weatherDescription,
                                    simpleTime.format(date),
                                    simpleDate.format(date),
                                    currentWeather.feels_like,
                                    currentWeather.pressure,
                                    currentWeather.humidity,
                                    currentWeather.clouds,
                                    currentWeather.visibility,
                                    currentWeather.windSpeed
                                )
                            )

                        } else if (currentWeather.weatherMain.equals("Drizzle") ||
                            currentWeather.weatherMain.equals("Snow")
                            || currentWeather.weatherMain.equals("Rain")
                        ) {
                            mainFeaturesLive.postValue(
                                MainFeatures(
                                    R.drawable.rain_ani,
                                    weatherEntity!!.city,
                                    currentWeather.weatherDescription,
                                    simpleTime.format(date),
                                    simpleDate.format(date),
                                    currentWeather.feels_like,
                                    currentWeather.pressure,
                                    currentWeather.humidity,
                                    currentWeather.clouds,
                                    currentWeather.visibility,
                                    currentWeather.windSpeed
                                )
                            )
                        } else {
                            if (current in weatherEntity!!.sunrise!!..weatherEntity!!.sunset!!) {
                                if (currentWeather.weatherMain.equals("Clear")) {
                                    mainFeaturesLive.postValue(
                                        MainFeatures(
                                            R.drawable.sunny_anim,
                                            weatherEntity!!.city,
                                            currentWeather.weatherDescription,
                                            simpleTime.format(date),
                                            simpleDate.format(date),
                                            currentWeather.feels_like,
                                            currentWeather.pressure,
                                            currentWeather.humidity,
                                            currentWeather.clouds,
                                            currentWeather.visibility,
                                            currentWeather.windSpeed
                                        )
                                    )
                                } else {
                                    mainFeaturesLive.postValue(
                                        MainFeatures(
                                            R.drawable.cloud_46,
                                            weatherEntity!!.city,
                                            currentWeather.weatherDescription,
                                            simpleTime.format(date),
                                            simpleDate.format(date),
                                            currentWeather.feels_like,
                                            currentWeather.pressure,
                                            currentWeather.humidity,
                                            currentWeather.clouds,
                                            currentWeather.visibility,
                                            currentWeather.windSpeed
                                        )
                                    )
                                }
                            } else {
                                if (currentWeather.weatherMain.equals("Clear")) {
                                    mainFeaturesLive.postValue(
                                        MainFeatures(
                                            R.drawable.moon_night,
                                            weatherEntity!!.city,
                                            currentWeather.weatherDescription,
                                            simpleTime.format(date),
                                            simpleDate.format(date),
                                            currentWeather.feels_like,
                                            currentWeather.pressure,
                                            currentWeather.humidity,
                                            currentWeather.clouds,
                                            currentWeather.visibility,
                                            currentWeather.windSpeed
                                        )
                                    )
                                } else {
                                    mainFeaturesLive.postValue(
                                        MainFeatures(
                                            R.drawable.cloud_46,
                                            weatherEntity!!.city,
                                            currentWeather.weatherDescription,
                                            simpleTime.format(date),
                                            simpleDate.format(date),
                                            currentWeather.feels_like,
                                            currentWeather.pressure,
                                            currentWeather.humidity,
                                            currentWeather.clouds,
                                            currentWeather.visibility,
                                            currentWeather.windSpeed
                                        )
                                    )
                                }
                            }
                        }

                    }
                }
                delay(1000)
            }


        }

    }


    fun getMainFeatures(): LiveData<MainFeatures> {
        return mainFeaturesLive
    }

    fun getHourlyList(): LiveData<List<Hourly>> {
        return liveHourly
    }

    override fun onCleared() {
        liveData.removeObserver(observer)
        job.cancel()
        super.onCleared()
    }


}