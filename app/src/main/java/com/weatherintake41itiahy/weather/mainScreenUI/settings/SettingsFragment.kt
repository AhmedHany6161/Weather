package com.weatherintake41itiahy.weather.mainScreenUI.settings

import android.content.Intent
import android.os.Bundle
import android.widget.NumberPicker
import android.widget.Toast
import androidx.preference.ListPreference
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.map.MapsActivity


class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
        getLocation()
        setSelectLocation()
    }

    private fun getLocation() {
        val preference: Preference? = findPreference("set_location")
        preference?.onPreferenceClickListener =
            object : PreferenceManager.OnPreferenceTreeClickListener,
                Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference?): Boolean {
                    val map = Intent(activity, MapsActivity::class.java)
                    startActivityForResult(map, 55)
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
        homeS?.onPreferenceChangeListener = object : Preference.OnPreferenceChangeListener {
            override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
                valueOfSelection?.isVisible = !newValue.toString().equals("GPS")
                return true
            }

        }

    }
}