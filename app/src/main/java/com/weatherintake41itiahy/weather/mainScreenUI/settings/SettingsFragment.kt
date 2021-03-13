package com.weatherintake41itiahy.weather.mainScreenUI.settings

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.preference.*
import androidx.work.WorkManager
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.map.MapsActivity
import com.weatherintake41itiahy.weather.work.WorkProcess
import java.text.DecimalFormat
import java.text.NumberFormat


class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var pref: SharedPreferences
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        getLocation()
        setSelectLocation()
        addAlert()
        stopAlert()
        pref = PreferenceManager.getDefaultSharedPreferences(requireContext())

    }


    private fun getLocation() {
        val preference: Preference? = findPreference("set_location")
        preference?.onPreferenceClickListener =
            object : PreferenceManager.OnPreferenceTreeClickListener,
                Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference?): Boolean {
                    if (isConnected()) {
                        val map = Intent(activity, MapsActivity::class.java)
                        requireActivity().startActivityForResult(map, 55)
                    } else {
                        Toast.makeText(context, "no internet connection", Toast.LENGTH_LONG).show()
                    }
                    return true
                }

                override fun onPreferenceTreeClick(preference: Preference?): Boolean {

                    return true
                }

            }
    }

    private fun locationPermissionState(): Boolean {
        return (ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        )
                == PackageManager.PERMISSION_GRANTED)
                && ContextCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
    }

    private fun isConnected(): Boolean {
        val connectivityManager =
            context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities =
                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                    return true
                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                    return true
                }
            }
        } else {
            try {
                val activeNetworkInfo = connectivityManager.activeNetworkInfo
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                    return true
                }
            } catch (e: Exception) {
                Log.i("update_statut", "" + e.message)
            }
        }
        return false
    }

    private fun getLocationPermission() {
        ActivityCompat.requestPermissions(
            requireActivity(), arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), 99
        )
    }

    private fun setSelectLocation() {
        val homeS: ListPreference? = findPreference("home_location")
        val valueOfSelection: Preference? = findPreference("set_location")
        if (homeS?.value != "Select Manually") {
            valueOfSelection?.isVisible = false
        }
        homeS?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->
                if (newValue.toString() == "GPS") {
                    valueOfSelection?.isVisible = false
                    if (!locationPermissionState()) {
                        getLocationPermission()
                    }
                } else {
                    valueOfSelection?.isVisible = true
                }
                true
            }


    }

    private fun stopAlert() {
        val alert: SwitchPreferenceCompat? = findPreference("alert_on")
        val setting: PreferenceCategory? = findPreference("alert_setting")
        setting?.isVisible = alert?.isChecked!!
        alert.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->
                if (newValue == false) {
                    setting?.isVisible = false
                    WorkProcess.getInstance(application = requireActivity().application)
                        .cancelAlert()
                    pref.edit().putString("time", requireContext().getString(R.string.select_the_time)).apply()
                } else {
                    setting?.isVisible = true
                }
                true
            }


    }

    private fun addAlert() {
        val addAlert: Preference? = findPreference("set_Alert")
        addAlert?.onPreferenceClickListener =
            object : PreferenceManager.OnPreferenceTreeClickListener,
                Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference?): Boolean {
                    findNavController().navigate(R.id.Alert)
                    return true
                }

                override fun onPreferenceTreeClick(preference: Preference?): Boolean {

                    return true
                }

            }


    }
}