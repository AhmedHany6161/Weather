package com.weatherintake41itiahy.weather.map

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.weatherintake41itiahy.weather.R
import java.util.*


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private var latLng: LatLng? = null
    private var preference: SharedPreferences? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        addNewLocation()
    }

    private fun addNewLocation() {
        val floatingActionButton: FloatingActionButton = findViewById(R.id.add_new_location)
        floatingActionButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val intent = Intent()
                if (latLng != null) {
                    intent.putExtra("Latitude", "${latLng?.latitude}")
                    intent.putExtra("longitude", "${latLng?.longitude}")
                    setResult(RESULT_OK, intent)
                    finish()
                } else {
                   Toast.makeText(this@MapsActivity,"please select location",Toast.LENGTH_LONG).show()
                }

            }

        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        googleMap.uiSettings.isZoomControlsEnabled = true
        googleMap.uiSettings.isRotateGesturesEnabled = true
        googleMap.uiSettings.isScrollGesturesEnabled = true
        googleMap.uiSettings.isTiltGesturesEnabled = true
         googleMap.mapType=GoogleMap.MAP_TYPE_HYBRID
        googleMap.setOnMapClickListener {
            googleMap.clear()
            latLng = it
            googleMap.addMarker(MarkerOptions().position(it).title("Home"))
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(it))
        }

    }

}