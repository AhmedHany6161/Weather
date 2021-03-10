package com.weatherintake41itiahy.weather.alert.cityPicker

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.R

class CityPicker : Fragment() {

    private lateinit var viewModel: CityPickerViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProvider(this).get(CityPickerViewModel::class.java)
        val root = inflater.inflate(R.layout.city_picker_fragment, container, false)
        val rec: RecyclerView = root.findViewById(R.id.city_picker_rec)
        rec.layoutManager = LinearLayoutManager(context)
        val adapter = PickerAdapter(viewModel)
        rec.adapter = adapter
        viewModel.getData().observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                adapter.setData(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.getObjectIntent().observe(viewLifecycleOwner,{
            if(it!=null){
                val b: Bundle= bundleOf("cityName" to it.city)
                findNavController().navigate(R.id.weatherPicker,b)
                viewModel.reset()
            }
        })
        return root
    }


}