package com.weatherintake41itiahy.weather.alert.weatherPicker

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.weatherintake41itiahy.weather.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "cityName"


class weatherPicker : Fragment() {
    private var cityName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityName = it.getString(ARG_PARAM1)
        }
        requireActivity().requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_weather_picker, container, false)
        val rain: Button = root.findViewById(R.id.pickRain)
        val temp: Button = root.findViewById(R.id.pickTemp)
        val wind: Button = root.findViewById(R.id.pickWind)
        val mist: Button = root.findViewById(R.id.pickMist)
        val snow: Button = root.findViewById(R.id.pickSnow)
        val cloud: Button = root.findViewById(R.id.pickCloud)
        val thunder: Button = root.findViewById(R.id.pickThunderStorm)
        rain.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "Rain")
            findNavController().navigate(R.id.alertPref, b)

        }
        temp.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "temp")
            findNavController().navigate(R.id.alertPref, b)


        }
        wind.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "wind")
            findNavController().navigate(R.id.alertPref, b)


        }
        thunder.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "Thunderstorm")
            findNavController().navigate(R.id.alertPref, b)


        }
        mist.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "Mist,Smoke,Haze,Fog,Sand,Dust,Tornado,Squall,Ash")
            findNavController().navigate(R.id.alertPref, b)


        }
        snow.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "Snow")
            findNavController().navigate(R.id.alertPref, b)


        }
        cloud.setOnClickListener {
            val b: Bundle = bundleOf("cityName" to cityName, "weatherState" to "cloud")
            findNavController().navigate(R.id.alertPref, b)


        }

        return root
    }

    override fun onDestroy() {
        requireActivity().requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        super.onDestroy()
    }

}