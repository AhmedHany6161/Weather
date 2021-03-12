package com.weatherintake41itiahy.weather.alert.mainSreen

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TimePicker
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.work.WorkProcess
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


class Alert : Fragment() {

    private lateinit var viewModel: AlertViewModel
    private lateinit var adapter: AlertAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_alert, container, false)
        val getTime: Button = root.findViewById(R.id.alertPickTime)
        val navigate: FloatingActionButton = root.findViewById(R.id.add_new_alert)
        val pref = PreferenceManager.getDefaultSharedPreferences(context)
        val f: NumberFormat = DecimalFormat("00")
        val time = pref.getString("time", "select the time")
        getTime.text = time
        getTime.setOnClickListener {
            val timePickerDialog =
                TimePickerDialog(context, object : TimePickerDialog.OnTimeSetListener {
                    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                        getTime.text = "${f.format(hourOfDay)} : ${f.format(minute)}"
                        pref.edit().putString("time", getTime.text.toString()).apply()
                        val setHour = hourOfDay - Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
                        val setMinute = minute - Calendar.getInstance().get(Calendar.MINUTE)
                        var initTime = ((setHour * 60) + setMinute).toLong()
                        if (initTime < 0) {
                            initTime += 1440
                        }
                        WorkProcess.getInstance(application = requireActivity().application)
                            .setAlert(
                                initTime,
                                pref.getString("alert_for_next", "86400")!!.toLong()
                            )

                    }

                }, 12, 0, false)
            timePickerDialog.show()
        }

        navigate.setOnClickListener {
            findNavController().navigate(R.id.cityPicker)
        }

        viewModel =
            ViewModelProvider(this).get(AlertViewModel::class.java)
        val rec: RecyclerView = root.findViewById(R.id.alerts_rec)
        rec.layoutManager = LinearLayoutManager(context)
        adapter = AlertAdapter(viewModel)
        rec.adapter = adapter
        viewModel.getData().observe(viewLifecycleOwner, {
            if (!it.isNullOrEmpty()) {
                adapter.setData(it)
                adapter.notifyDataSetChanged()
            }
        })
        viewModel.getObjectIntent().observe(viewLifecycleOwner, {
            if (it != null) {
                val b: Bundle = bundleOf("alert" to it)
                findNavController().navigate(R.id.alertPref, b)
                viewModel.reset()
            }
        })
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(rec)
        return root
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
                viewModel.deleteItem(adapter.deleteItem(position))
                dialog.cancel()
            }
            builder.setNegativeButton("cancel") { dialog, id ->
                adapter.notifyDataSetChanged()
                dialog.cancel()
            }
            builder.show()

        }
    }
}