package com.weatherintake41itiahy.weather.model.entity;

import java.lang.System;

@androidx.room.TypeConverters(value = {com.weatherintake41itiahy.weather.model.entity.converters.HourlyConverter.class, com.weatherintake41itiahy.weather.model.entity.converters.DailyConverter.class})
@androidx.room.Entity()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001e\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001f\u001a\u00020\u0006H\u00c6\u0003J\t\u0010 \u001a\u00020\u0003H\u00c6\u0003J\t\u0010!\u001a\u00020\nH\u00c6\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0003Je\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fH\u00c6\u0001J\u0013\u0010%\u001a\u00020\n2\b\u0010&\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\'\u001a\u00020(H\u00d6\u0001J\t\u0010)\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012\u00a8\u0006*"}, d2 = {"Lcom/weatherintake41itiahy/weather/model/entity/WeatherEntity;", "", "city", "", "latLng", "sunrise", "", "sunset", "timeZone", "isTheCurrent", "", "listOfHourly", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "listOfDaily", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Daily;", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "getCity", "()Ljava/lang/String;", "()Z", "getLatLng", "getListOfDaily", "()Ljava/util/List;", "getListOfHourly", "getSunrise", "()J", "getSunset", "getTimeZone", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class WeatherEntity {
    @org.jetbrains.annotations.NotNull()
    @androidx.room.PrimaryKey()
    private final java.lang.String city = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String latLng = null;
    private final long sunrise = 0L;
    private final long sunset = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String timeZone = null;
    private final boolean isTheCurrent = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> listOfDaily = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLatLng() {
        return null;
    }
    
    public final long getSunrise() {
        return 0L;
    }
    
    public final long getSunset() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeZone() {
        return null;
    }
    
    public final boolean isTheCurrent() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> getListOfHourly() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> getListOfDaily() {
        return null;
    }
    
    public WeatherEntity(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String latLng, long sunrise, long sunset, @org.jetbrains.annotations.NotNull()
    java.lang.String timeZone, boolean isTheCurrent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly, @org.jetbrains.annotations.NotNull()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> listOfDaily) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final long component4() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Daily> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.weatherintake41itiahy.weather.model.entity.WeatherEntity copy(@org.jetbrains.annotations.NotNull()
    java.lang.String city, @org.jetbrains.annotations.NotNull()
    java.lang.String latLng, long sunrise, long sunset, @org.jetbrains.annotations.NotNull()
    java.lang.String timeZone, boolean isTheCurrent, @org.jetbrains.annotations.NotNull()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> listOfHourly, @org.jetbrains.annotations.NotNull()
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