package com.weatherintake41itiahy.weather.model.room;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f0\u000bH\'J\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\f0\u000bH\'J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\'J\u0019\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0019\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\rH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001b"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/room/WeatherDAO;", "", "delete", "", "weather", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "(Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteHome", "getAllAlerts", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/weatherintake41itiahy/weather/model/entity/AlertEntity;", "getAllAlertsVal", "getAllWeather", "getFavoriteWeather", "getHomeWeather", "getWeatherVal", "cityName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAlert", "alertEntity", "(Lcom/weatherintake41itiahy/weather/model/entity/AlertEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setWeather", "updateAlert", "app_debug"})
public abstract interface WeatherDAO {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM WeatherEntity where isTheCurrent=0")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getFavoriteWeather();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM WeatherEntity where isTheCurrent=1")
    public abstract kotlinx.coroutines.flow.Flow<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> getHomeWeather();
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM WeatherEntity")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getAllWeather();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM WeatherEntity where  city == :cityName ")
    public abstract java.lang.Object getWeatherVal(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.weatherintake41itiahy.weather.model.entity.WeatherEntity> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object setWeather(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Delete()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weather, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM WeatherEntity ")
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "DELETE FROM WeatherEntity where isTheCurrent=1")
    public abstract java.lang.Object deleteHome(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object setAlert(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.AlertEntity alertEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM AlertEntity")
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.AlertEntity>> getAllAlerts();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM AlertEntity")
    public abstract java.lang.Object getAllAlertsVal(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.weatherintake41itiahy.weather.model.entity.AlertEntity>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Update()
    public abstract java.lang.Object updateAlert(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.AlertEntity alertEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
}