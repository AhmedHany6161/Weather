package com.weatherintake41itiahy.weather.alert.mainSreen

import android.app.Application
import androidx.lifecycle.*
import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlertViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: Repository = Repository.getInstance(application)
    private var open: MutableLiveData<AlertEntity> = MutableLiveData()
    private val liveData: LiveData<List<AlertEntity>> =
        repository.getAllAlerts().asLiveData()

    fun getData(): LiveData<List<AlertEntity>> {
        return liveData
    }

    fun onPassData(alertEntity: AlertEntity) {
        open.value = alertEntity
    }

    fun reset() {
        open.value = null
    }

    fun getObjectIntent(): LiveData<AlertEntity> {
        return open
    }

    fun updateAlert(alertEntity: AlertEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateAlert(alertEntity)
        }
    }

    fun deleteItem(alertEntity: AlertEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAlert(alertEntity)
        }
    }
}