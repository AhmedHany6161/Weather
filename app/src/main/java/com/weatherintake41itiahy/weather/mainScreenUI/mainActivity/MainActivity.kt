package com.weatherintake41itiahy.weather.mainScreenUI.mainActivity

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.AnimationDrawable
import android.location.LocationListener
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.weatherintake41itiahy.weather.R
import java.util.*


class MainActivity : AppCompatActivity() {

    private var mainActivityViewModel: MainActivityViewModel? = null
    private lateinit var locationManager: LocationManager
    private lateinit var listener: LocationListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        listener = LocationListener {
            Log.e("hhhhh", "h")
            mainActivityViewModel?.upDateHomeWeather(
                it.latitude.toString(),
                it.longitude.toString()
            )
        }
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.settingsFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        mainActivityViewModel =
            ViewModelProvider(this).get(MainActivityViewModel::class.java)

        setAnimated()
        if (mainActivityViewModel!!.isOpenGPS()) {
            createLocationLis()
        }

        mainActivityViewModel?.getLivePrefLocation()?.observe(this, {
            if (it != "Select Manually") {
                Log.e("eeeeeeee", it)

                createLocationLis()
            } else {
                Log.e("eeeeeeee", it)
                locationManager.removeUpdates(listener)
            }
        })

        mainActivityViewModel?.getLivePrefLang()?.observe(this, {
            if (it != null) {
                setLocal(it)
                finish()
                startActivity(intent)
                mainActivityViewModel?.resetLang()
            }
        })
        setLocal(mainActivityViewModel?.getLang()!!)
    }

    @Suppress("DEPRECATION")
    private fun setLocal(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)
        val res: Resources = resources
        val resApp: Resources = application.resources
        val config: Configuration = Configuration(res.configuration)
        val configApp: Configuration = Configuration(resApp.configuration)
        config.setLocale(locale)
        configApp.setLocale(locale)
        //application.createConfigurationContext(config)
        res.updateConfiguration(config, res.displayMetrics)
        resApp.updateConfiguration(configApp, res.displayMetrics)

    }


    private fun setAnimated() {
        val constraintLayout = findViewById<ConstraintLayout>(R.id.main_container)
        val animationDrawable = constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(0)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            val latitude = data?.getStringExtra("Latitude")!!
            val longitude = data.getStringExtra("longitude")!!
            Log.e("request_main", "$requestCode")
            if (requestCode == 55) {
                mainActivityViewModel?.upDateHomeWeather(latitude, longitude)
            } else {
                mainActivityViewModel?.upDateFavWeather(latitude, longitude)
            }
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 99 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "permission deny we can not enable GPS", Toast.LENGTH_LONG).show()
            mainActivityViewModel?.closeGPS()
        }
    }

    private fun createLocationLis() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            getLocationPermission()
        } else {

            locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 5000, 1000f, listener
            )

        }
    }


    private fun getLocationPermission() {
        ActivityCompat.requestPermissions(
            this, arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ), 99
        )
    }

}