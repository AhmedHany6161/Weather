package com.weatherintake41itiahy.weather.mainScreenUI.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\fH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0016J$\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0016\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\tR\u0012\u0010\n\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/weatherintake41itiahy/weather/mainScreenUI/home/HomeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/weatherintake41itiahy/weather/mainScreenUI/home/HomeAdapter$Holder;", "()V", "list", "", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "sunrise", "", "Ljava/lang/Long;", "sunset", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setData", "Holder", "app_debug"})
public final class HomeAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.weatherintake41itiahy.weather.mainScreenUI.home.HomeAdapter.Holder> {
    private java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> list;
    private java.lang.Long sunrise;
    private java.lang.Long sunset;
    
    public final void setData(long sunrise, long sunset, @org.jetbrains.annotations.NotNull()
    java.util.List<com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly> list) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.weatherintake41itiahy.weather.mainScreenUI.home.HomeAdapter.Holder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.weatherintake41itiahy.weather.mainScreenUI.home.HomeAdapter.Holder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public HomeAdapter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/weatherintake41itiahy/weather/mainScreenUI/home/HomeAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "clouds", "Landroid/widget/TextView;", "image", "Landroid/widget/ImageView;", "imageId", "", "main", "temp", "time", "windSpeed", "bind", "", "currentWeather", "Lcom/weatherintake41itiahy/weather/model/entity/weatherTimes/Hourly;", "sunrise", "", "sunset", "app_debug"})
    public static final class Holder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView windSpeed = null;
        private final android.widget.ImageView image = null;
        private final android.widget.TextView temp = null;
        private final android.widget.TextView time = null;
        private final android.widget.TextView main = null;
        private final android.widget.TextView clouds = null;
        private int imageId = 0;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.weatherintake41itiahy.weather.model.entity.weatherTimes.Hourly currentWeather, long sunrise, long sunset) {
        }
        
        public Holder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}