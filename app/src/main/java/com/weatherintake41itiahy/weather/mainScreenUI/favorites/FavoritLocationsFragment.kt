package com.weatherintake41itiahy.weather.mainScreenUI.favorites

import android.content.Context
import android.content.DialogInterface
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
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.map.MapsActivity


class FavoritLocationsFragment : Fragment() {

    private lateinit var favoriteLocationsViewModel: FavoritLocationsViewModel
    private lateinit var adapter: FavAdapter
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
        adapter = FavAdapter(favoriteLocationsViewModel)
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
        favoriteLocationsViewModel.getFavObjectIntent().observe(viewLifecycleOwner, {
            if (it != null) {
                val b: Bundle = bundleOf("data" to it)
                findNavController().navigate(R.id.favViewer, b)
                favoriteLocationsViewModel.reset()
            }
        })
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(rec)
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

    private var simpleItemTouchCallback: ItemTouchHelper.SimpleCallback = object :
        ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT or ItemTouchHelper.DOWN or ItemTouchHelper.UP
        ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ): Boolean {
            return false
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
            val builder: AlertDialog.Builder = AlertDialog.Builder(requireContext())

            builder.setTitle("delete")
            builder.setMessage("you want to delete this item")
            builder.setCancelable(false)
            builder.setPositiveButton("ok") { dialog, id ->
                val position = viewHolder.adapterPosition
                adapter.notifyItemRemoved(position)
                favoriteLocationsViewModel.deleteItem(adapter.deleteItem(position))
                dialog.cancel()
            }
            builder.setNegativeButton("cancel"){ dialog, id ->
              adapter.notifyDataSetChanged()
                dialog.cancel()
            }
            builder.show()

        }
    }
}