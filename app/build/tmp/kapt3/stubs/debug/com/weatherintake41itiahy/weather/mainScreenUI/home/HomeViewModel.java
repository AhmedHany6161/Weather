package com.weatherintake41itiahy.weather.mainScreenUI.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bJ\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\u001b\u001a\u00020\u001cH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lcom/weatherintake41itiahy/weather/mainScreenUI/home/HomeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "list", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "liveData", "Landroidx/lifecycle/LiveData;", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "mainFeaturesLive", "Landroidx/lifecycle/MutableLiveData;", "Lcom/weatherintake41itiahy/weather/screenDataObj/MainFeatures;", "observer", "Landroidx/lifecycle/Observer;", "repository", "Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "weatherEntity", "getWeatherEntity", "()Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "setWeatherEntity", "(Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;)V", "getMainFeatures", "getWeather", "onCleared", "", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.weatherintake41itiahy.weather.model.repository.Repository repository = null;
    private final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> liveData = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final androidx.lifecycle.MutableLiveData<com.weatherintake41itiahy.weather.screenDataObj.MainFeatures> mainFeaturesLive = null;
    private java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> list;
    @org.jetbrains.annotations.Nullable()
    private com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity;
    private final androidx.lifecycle.Observer<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> observer = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.weatherintake41itiahy.weather.model.entity.WeatherEntity getWeatherEntity() {
        return null;
    }
    
    public final void setWeatherEntity(@org.jetbrains.annotations.Nullable()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.screenDataObj.MainFeatures> getMainFeatures() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> getWeather() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}