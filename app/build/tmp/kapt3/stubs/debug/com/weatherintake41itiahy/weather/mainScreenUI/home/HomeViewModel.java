package com.weatherintake41itiahy.weather.mainScreenUI.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000bJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/weatherintake41itiahy/weather/mainScreenUI/home/HomeViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "job", "Lkotlinx/coroutines/CompletableJob;", "list", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "liveData", "Landroidx/lifecycle/LiveData;", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "liveHourly", "Landroidx/lifecycle/MutableLiveData;", "mainFeaturesLive", "Lcom/weatherintake41itiahy/weather/screenDataObj/MainFeatures;", "observer", "Landroidx/lifecycle/Observer;", "repository", "Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "weatherEntity", "getHourlyList", "getMainFeatures", "onCleared", "", "app_debug"})
public final class HomeViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.weatherintake41itiahy.weather.model.repository.Repository repository = null;
    private final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> liveData = null;
    private final kotlinx.coroutines.CompletableJob job = null;
    private final androidx.lifecycle.MutableLiveData<com.weatherintake41itiahy.weather.screenDataObj.MainFeatures> mainFeaturesLive = null;
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly>> liveHourly = null;
    private java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> list;
    private com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity;
    private final androidx.lifecycle.Observer<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> observer = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.screenDataObj.MainFeatures> getMainFeatures() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly>> getHourlyList() {
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