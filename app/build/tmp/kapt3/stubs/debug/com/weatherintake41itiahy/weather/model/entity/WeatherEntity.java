package com.weatherintake41itiahy.weather.model.entity;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.weatherintake41itiahy.weather.model.entity.converters.HourlyConverter.class, com.weatherintake41itiahy.weather.model.entity.converters.DailyConverter.class})
@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\u000fJ\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0019J\u0010\u0010 \u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u00c6\u0003J\u0011\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bH\u00c6\u0003Jl\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000bH\u00c6\u0001\u00a2\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020\t2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\b\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019\u00a8\u0006*"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "", "city", "", "latLng", "sunrise", "", "sunset", "isTheCurrent", "", "listOfHourly", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "listOfDaily", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Daily;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)V", "getCity", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLatLng", "getListOfDaily", "()Ljava/util/List;", "getListOfHourly", "getSunrise", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getSunset", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;)Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class WeatherEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private final java.lang.String city = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String latLng = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long sunrise = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long sunset = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isTheCurrent = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> listOfDaily = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getLatLng() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSunrise() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSunset() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isTheCurrent() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> getListOfHourly() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> getListOfDaily() {
        return null;
    }
    
    public WeatherEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.Nullable()
    java.lang.String latLng, @org.jetbrains.annotations.Nullable()
    java.lang.Long sunrise, @org.jetbrains.annotations.Nullable()
    java.lang.Long sunset, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isTheCurrent, @org.jetbrains.annotations.Nullable()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly, @org.jetbrains.annotations.Nullable()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> listOfDaily) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.weatherintake41itiahy.weather.model.entity.WeatherEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.Nullable()
    java.lang.String latLng, @org.jetbrains.annotations.Nullable()
    java.lang.Long sunrise, @org.jetbrains.annotations.Nullable()
    java.lang.Long sunset, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isTheCurrent, @org.jetbrains.annotations.Nullable()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly, @org.jetbrains.annotations.Nullable()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> listOfDaily) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}