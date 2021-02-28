package com.weatherintake41itiahy.weather.model.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u001aJ\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\f0\u001aJ.\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\"R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "services", "Lcom/weatherintake41itiahy/weather/model/network/WeatherServices;", "tag", "", "weatherDAO", "Lcom/weatherintake41itiahy/weather/model/room/WeatherDAO;", "convertToDailyList", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Daily;", "jsonArray", "Lcom/google/gson/JsonArray;", "convertToHourlyList", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "offset", "", "deleteAll", "", "deleteItem", "weatherEntity", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "geHomeWeather", "Lkotlinx/coroutines/flow/Flow;", "getFavoriteLocations", "updateWeatherData", "lat", "lon", "time", "city", "home", "", "app_debug"})
public final class Repository {
    private final java.lang.String tag = null;
    private final com.weatherintake41itiahy.weather.model.room.WeatherDAO weatherDAO = null;
    private final com.weatherintake41itiahy.weather.model.network.WeatherServices services = null;
    
    public final void updateWeatherData(@org.jetbrains.annotations.NotNull()
    java.lang.String lat, @org.jetbrains.annotations.NotNull()
    java.lang.String lon, long time, @org.jetbrains.annotations.NotNull()
    java.lang.String city, boolean home) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> geHomeWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getFavoriteLocations() {
        return null;
    }
    
    public final void deleteItem(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity) {
    }
    
    public final void deleteAll() {
    }
    
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> convertToDailyList(com.google.gson.JsonArray jsonArray) {
        return null;
    }
    
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> convertToHourlyList(com.google.gson.JsonArray jsonArray, long offset) {
        return null;
    }
    
    public Repository(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
}