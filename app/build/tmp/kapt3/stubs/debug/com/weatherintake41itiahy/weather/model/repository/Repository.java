package com.weatherintake41itiahy.weather.model.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0013H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0011\u0010\u0019\u001a\u00020\u0013H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0019\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001dJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001fJ\u0012\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\f0\u001fJ\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00150\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f0\u001fJ\u0012\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\f0\u001fJ\u0019\u0010$\u001a\u00020\u001c2\u0006\u0010%\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010&J\u0019\u0010\'\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J\u0019\u0010(\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016J1\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\u0006\u0010,\u001a\u00020-H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010.R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00060"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "services", "Lcom/weatherintake41itiahy/weather/model/network/WeatherServices;", "tag", "", "weatherDAO", "Lcom/weatherintake41itiahy/weather/model/room/WeatherDAO;", "convertToDailyList", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Daily;", "jsonArray", "Lcom/google/gson/JsonArray;", "convertToHourlyList", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "deleteAlert", "", "alertEntity", "Lcom/weatherintake41itiahy/weather/model/entity/AlertEntity;", "(Lcom/weatherintake41itiahy/weather/model/entity/AlertEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteHome", "deleteItem", "weatherEntity", "Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "(Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "geHomeWeather", "Lkotlinx/coroutines/flow/Flow;", "getAllAlerts", "getAllAlertsValue", "getAllWeather", "getFavoriteLocations", "getWeatherById", "city", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setAlert", "updateAlert", "updateWeatherData", "lat", "lon", "home", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class Repository {
    private final java.lang.String tag = null;
    private final com.weatherintake41itiahy.weather.model.room.WeatherDAO weatherDAO = null;
    private final com.weatherintake41itiahy.weather.model.network.WeatherServices services = null;
    private static com.weatherintake41itiahy.weather.model.repository.Repository repository;
    @org.jetbrains.annotations.NotNull()
    public static final com.weatherintake41itiahy.weather.model.repository.Repository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateWeatherData(@org.jetbrains.annotations.NotNull()
    java.lang.String lat, @org.jetbrains.annotations.NotNull()
    java.lang.String lon, @org.jetbrains.annotations.NotNull()
    java.lang.String city, boolean home, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p4) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.weatherintake41itiahy.weather.model.entity.WeatherEntity> geHomeWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.AlertEntity>> getAllAlerts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getFavoriteLocations() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.weatherintake41itiahy.weather.model.entity.WeatherEntity>> getAllWeather() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteItem(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.WeatherEntity weatherEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object setAlert(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.AlertEntity alertEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateAlert(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.AlertEntity alertEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> convertToDailyList(com.google.gson.JsonArray jsonArray) {
        return null;
    }
    
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> convertToHourlyList(com.google.gson.JsonArray jsonArray) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAllAlertsValue(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.weatherintake41itiahy.weather.model.entity.AlertEntity>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWeatherById(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.weatherintake41itiahy.weather.model.entity.WeatherEntity> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteAlert(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.model.entity.AlertEntity alertEntity, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    private Repository(android.app.Application application) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/repository/Repository$Companion;", "", "()V", "repository", "Lcom/weatherintake41itiahy/weather/model/repository/Repository;", "getInstance", "application", "Landroid/app/Application;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.weatherintake41itiahy.weather.model.repository.Repository getInstance(@org.jetbrains.annotations.NotNull()
        android.app.Application application) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}