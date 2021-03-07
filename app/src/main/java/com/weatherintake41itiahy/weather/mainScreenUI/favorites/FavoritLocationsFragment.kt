package com.weatherintake41itiahy.weather.mainScreenUI.favorites

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.map.MapsActivity


class FavoritLocationsFragment : Fragment() {

    private lateinit var favoriteLocationsViewModel: FavoritLocationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoriteLocationsViewModel =
            ViewModelProvider(this).get(FavoritLocationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_favorites_locations, container, false)
        val addFav: FloatingActionButton = root.findViewById(R.id.fav_add_btn)
        addFav.animation =
            AnimationUtils.loadAnimation(context, R.anim.main_screen_anim_left_right)
        val rec: RecyclerView = root.findViewById(R.id.fav_fragment_rec)
        val noDataTx: TextView = root.findViewById(R.id.fav_t_no_data)
        val customP: FrameLayout = root.findViewById(R.id.fav_p_no_data)

        rec.layoutManager = LinearLayoutManager(context)
        val adapter = FavAdapter()
        rec.adapter = adapter
        favoriteLocationsViewModel.getFavorites().observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                customP.visibility = View.GONE
                noDataTx.visibility = View.GONE
                adapter.setData(it)
                adapter.notifyDataSetChanged()
            } else {
                customP.visibility = View.GONE
                noDataTx.visibility = View.VISIBLE
            }
        })
        addFav.setOnClickListener {
            if (isConnected()) {
                val map = Intent(activity, MapsActivity::class.java)
                requireActivity().startActivityForResult(map, 66)
            } else {
                Toast.makeText(context, "no internet connection", Toast.LENGTH_LONG).show()
            }
        }
        return root
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
}