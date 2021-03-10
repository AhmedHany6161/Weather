package com.weatherintake41itiahy.weather.mainScreenUI.settings

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.preference.*
import androidx.work.WorkManager
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.map.MapsActivity
import com.weatherintake41itiahy.weather.work.WorkProcess
import java.text.DecimalFormat
import java.text.NumberFormat


class SettingsFragment : PreferenceFragmentCompat() {
    private lateinit var pref :SharedPreferences
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        getLocation()
        setSelectLocation()
        addAlert()
        stopAlert()
        pref= PreferenceManager.getDefaultSharedPreferences(requireContext())
    }


    private fun getLocation() {
        val preference: Preference? = findPreference("set_location")
        preference?.onPreferenceClickListener =
            object : PreferenceManager.OnPreferenceTreeClickListener,
                Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference?): Boolean {
                    val map = Intent(activity, MapsActivity::class.java)
                    requireActivity().startActivityForResult(map, 55)
                    return true
                }

                override fun onPreferenceTreeClick(preference: Preference?): Boolean {

                    return true
                }

            }
    }

    private fun setSelectLocation() {
        val homeS: ListPreference? = findPreference("home_location")

        val valueOfSelection: Preference? = findPreference("set_location")
        homeS?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->
                valueOfSelection?.isVisible = !newValue.toString().equals("GPS")
                true
            }


    }
    private fun stopAlert() {
        val alert: SwitchPreferenceCompat? = findPreference("alert_on")
        val setting: PreferenceCategory? = findPreference("alert_setting")
        alert?.onPreferenceChangeListener =
            Preference.OnPreferenceChangeListener { _, newValue ->
                    if(newValue==false) {
                        setting?.isVisible = false
                        WorkProcess.getInstance(application = requireActivity().application).cancelAlert()
                        pref.edit().putString("time", "select the time").apply()
                    }else{
                        setting?.isVisible = true
                    }
                true
            }


    }
    private fun addAlert() {
        val addAlert: Preference? = findPreference("set_Alert")
        addAlert?.onPreferenceClickListener= object : PreferenceManager.OnPreferenceTreeClickListener,
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