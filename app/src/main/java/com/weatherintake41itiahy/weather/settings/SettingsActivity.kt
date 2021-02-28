package com.weatherintake41itiahy.weather.settings

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceManager
import com.weatherintake41itiahy.weather.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_activity)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    class SettingsFragment : PreferenceFragmentCompat() {
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.root_preferences, rootKey)

        }

        fun getLocation(){
            val preference: Preference? =findPreference("set_location")
            preference?.onPreferenceClickListener = object :PreferenceManager.OnPreferenceTreeClickListener,
                Preference.OnPreferenceClickListener {
                override fun onPreferenceClick(preference: Preference?): Boolean {
                    Toast.makeText(activity,preference?.title,Toast.LENGTH_LONG).show()
                    return true
                }

                override fun onPreferenceTreeClick(preference: Preference?): Boolean {

                    return true
                }

            }
        }
    }
}