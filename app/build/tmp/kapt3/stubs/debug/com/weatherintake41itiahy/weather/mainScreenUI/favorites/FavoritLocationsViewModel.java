package com.weatherintake41itiahy.weather.mainScreenUI.favorites;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u0006J\u0012\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0013\u001a\u00020\u000eR\u001a\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/weatherintake41itiahy/weather/mainScreenUI/favorites/FavoritLocationsViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "liveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "openFav", "Landroidx/lifecycle/MutableLiveData;", "repository", "Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "deleteItem", "", "weatherEntity", "getFavObjectIntent", "getFavorites", "onPassData", "reset", "app_debug"})
public final class FavoritLocationsViewModel extends androidx.lifecycle.AndroidViewModel {
    private final com.weatherintake41itiahy.weather.model.repository.Repository repository = null;
    private androidx.lifecycle.MutableLiveData<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> openFav;
    private final androidx.lifecycle.LiveData<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> liveData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getFavorites() {
        return null;
    }
    
    public final void onPassData(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity) {
    }
    
    public final void reset() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> getFavObjectIntent() {
        return null;
    }
    
    public final void deleteItem(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity) {
    }
    
    public FavoritLocationsViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}