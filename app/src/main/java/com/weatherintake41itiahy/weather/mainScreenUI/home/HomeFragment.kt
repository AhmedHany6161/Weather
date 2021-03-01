package com.weatherintake41itiahy.weather.mainScreenUI.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import pl.droidsonroids.gif.GifImageView

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val cloudPercent: TextView = root.findViewById(R.id.cloudPercent)
        val time: TextView = root.findViewById(R.id.timeViewId)
        val date: TextView = root.findViewById(R.id.dateViewId)
        val imageState: GifImageView = root.findViewById(R.id.imageWeatherState)
        val city: TextView = root.findViewById(R.id.cityViewId)
        val dec: TextView = root.findViewById(R.id.textDescId)
        val temp: TextView = root.findViewById(R.id.main_temp)
        homeViewModel.getMainFeatures().observe(viewLifecycleOwner, {
            dec.text = it.disc
            city.text = it.city
            imageState.setImageResource(it.imageId)
            date.text = it.date
            time.text = it.time
            cloudPercent.text = " ${it.clouds}%"
            temp.text="${it.temp}°C"
        })
        val rec: RecyclerView = root.findViewById(R.id.HourlyRecHome)
        val adapter = HomeAdapter()
        rec.adapter = adapter
        rec.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        homeViewModel.getWeather().observe(viewLifecycleOwner, {

            adapter.setData(it.sunrise, it.sunset, it.listOfHourly)
            adapter.notifyDataSetChanged()

        })
        return root
    }
}