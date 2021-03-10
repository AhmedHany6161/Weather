package com.weatherintake41itiahy.weather.mainScreenUI.favViewer

import android.graphics.Paint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.mainScreenUI.home.DailyAdapter
import com.weatherintake41itiahy.weather.mainScreenUI.home.HourlyAdapter
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.screenData.WeatherFilterData
import pl.droidsonroids.gif.GifImageView
import java.util.*

class FavViewer : Fragment() {


    private lateinit var viewModel: FavViewerViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(FavViewerViewModel::class.java)

        val weatherEntity = requireArguments().get("data") as WeatherEntity?
        if (weatherEntity != null) {
            viewModel.setData(weatherEntity)
        }
        val cloudPercent: TextView = root.findViewById(R.id.cloudPercent)
        val proNoData: FrameLayout = root.findViewById(R.id.p_no_data)
        val homeData: LinearLayout = root.findViewById(R.id.home_data)
        val texNoData: TextView = root.findViewById(R.id.t_no_data)
        val time: TextClock = root.findViewById(R.id.timeViewId)
        val date: TextClock = root.findViewById(R.id.dateViewId)
        val imageState: GifImageView = root.findViewById(R.id.imageWeatherState)
        val city: TextView = root.findViewById(R.id.cityViewId)
        val dec: TextView = root.findViewById(R.id.textDescId)
        val temp: TextView = root.findViewById(R.id.main_temp)
        val visablity: TextView = root.findViewById(R.id.visiablity)
        val windDegree: TextView = root.findViewById(R.id.wind_degree)
        val windSpeed: TextView = root.findViewById(R.id.windSpeed)
        val pressure: TextView = root.findViewById(R.id.Pressure)
        val hum: TextView = root.findViewById(R.id.Humidity)
        val feelLike: TextView = root.findViewById(R.id.feels_like)
        val topMain: ConstraintLayout = root.findViewById(R.id.top_main_fe)
        val bottomMain: GridLayout = root.findViewById(R.id.bottom_main_fe)
        val filter = WeatherFilterData(requireContext())
        val hourlyRec: RecyclerView = root.findViewById(R.id.HourlyRecHome)
        val dailyRec: RecyclerView = root.findViewById(R.id.dailyRecHome)
        val showAndHideDaily: Button = root.findViewById(R.id.forecastFor7days)
        val outOfDate: TextView = root.findViewById(R.id.out_of_date)

        showAndHideDaily.paintFlags = showAndHideDaily.paintFlags or Paint.UNDERLINE_TEXT_FLAG


        val hourlyAdapter = HourlyAdapter()
        hourlyRec.adapter = hourlyAdapter
        hourlyRec.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val dailyAdapter = DailyAdapter()
        dailyRec.adapter = dailyAdapter
        dailyRec.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        showAndHideDaily.setOnClickListener {
            viewModel.showAndHideDaily()
        }
        viewModel.getMainFeatures().observe(viewLifecycleOwner, {
            if (it != null) {
                if (!homeData.isVisible) {
                    topMain.animation =
                        AnimationUtils.loadAnimation(context, R.anim.main_screen_anim_left_right)
                    bottomMain.animation =
                        AnimationUtils.loadAnimation(context, R.anim.main_screen_anim_left_right)
                    hourlyRec.animation =
                        AnimationUtils.loadAnimation(context, R.anim.main_screen_anim_left_right)
                }
                homeData.visibility = View.VISIBLE
                proNoData.visibility = View.GONE
                texNoData.visibility = View.GONE
                dec.text = it.disc
                city.text = it.city
                imageState.setImageResource(it.imageId)
                date.timeZone = it.timeZone
                time.timeZone = it.timeZone
                cloudPercent.text = " ${it.clouds}%"
                temp.text = filter.getTemp(it.temp)
                feelLike.text = "${getString(R.string.FeelLike)} ${filter.getTemp(it.feelsLike)}"
                hum.text = "${it.humidity}%"
                pressure.text = "${it.pressure}hPa"
                windSpeed.text = filter.getSpeedUnit(it.windSpeed)
                windDegree.text = "${it.windDegree}°"
                visablity.text = "${it.visibility}m"
                if (it.outOfDate) {
                    outOfDate.visibility = View.VISIBLE
                } else {
                    outOfDate.visibility = View.GONE
                }
            } else {
                texNoData.visibility = View.VISIBLE
                proNoData.visibility = View.GONE
                homeData.visibility = View.GONE

            }
        })


        viewModel.getWeather().observe(viewLifecycleOwner, {
            if (it != null) {


                hourlyAdapter.setData(
                    TimeZone.getTimeZone(it.timeZone),
                    it.sunrise,
                    it.sunset,
                    it.listOfHourly
                )
                hourlyAdapter.notifyDataSetChanged()
                dailyAdapter.setData(it.listOfDaily, TimeZone.getTimeZone(it.timeZone))
                dailyAdapter.notifyDataSetChanged()
            }
        })



        viewModel.getDailyVisibilityOfList().observe(viewLifecycleOwner, {
            if (it) {
                dailyRec.animation =
                    AnimationUtils.loadAnimation(context, R.anim.main_screen_anim_left_right)
                dailyRec.visibility = View.VISIBLE
                showAndHideDaily.text = getString(R.string.hide_cast_for_7_days)

            } else {
                dailyRec.animation =
                    AnimationUtils.loadAnimation(context, R.anim.main_sreen_anim_right_left)
                dailyRec.visibility = View.GONE
                showAndHideDaily.text = getString(R.string.show_cast_for_7_days)

            }
        })
        return root
    }



}