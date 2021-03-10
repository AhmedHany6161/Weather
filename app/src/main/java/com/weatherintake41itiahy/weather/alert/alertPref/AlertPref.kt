package com.weatherintake41itiahy.weather.alert.alertPref

import android.app.Activity
import android.app.TimePickerDialog
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.get
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import ca.antonious.materialdaypicker.MaterialDayPicker
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import com.weatherintake41itiahy.weather.model.entity.WeatherEntity
import com.weatherintake41itiahy.weather.model.repository.Repository
import kotlinx.coroutines.*
import java.text.DecimalFormat
import java.text.NumberFormat


private const val ARG_PARAM1 = "cityName"
private const val ARG_PARAM2 = "weatherState"


class AlertPref : Fragment() {
    private lateinit var cityName: String
    private lateinit var weatherState: String
    private val job = Job()
    private var from: Int = 0
    private var duration: Int = 23
    private var more: Boolean = true
    private var unitCount: Int = 0
    private var desc: String? = ""
    private var update: Boolean = false
    private var list: List<MaterialDayPicker.Weekday>? = null
    private var updateObj: AlertEntity? = null
    private var ls: List<String>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        arguments?.let {
            val obj = (it.getSerializable("alert") as AlertEntity?)
            if (obj != null) {
                updateObj = obj
                cityName = obj.city
                weatherState = obj.weatherState
                from = obj.from
                desc = obj.desc
                update = true
                unitCount = obj.unitCount
                more = obj.more
                ls = obj.listDays
                list = List(ls!!.size) { index ->
                    when (ls!![index]) {
                        MaterialDayPicker.Weekday[0].name -> {
                            MaterialDayPicker.Weekday[0]
                        }
                        MaterialDayPicker.Weekday[1].name -> {
                            MaterialDayPicker.Weekday[1]
                        }
                        MaterialDayPicker.Weekday[2].name -> {
                            MaterialDayPicker.Weekday[2]
                        }
                        MaterialDayPicker.Weekday[3].name -> {
                            MaterialDayPicker.Weekday[3]
                        }
                        MaterialDayPicker.Weekday[4].name -> {
                            MaterialDayPicker.Weekday[4]
                        }
                        MaterialDayPicker.Weekday[5].name -> {
                            MaterialDayPicker.Weekday[5]
                        }
                        else -> {
                            MaterialDayPicker.Weekday[6]
                        }
                    }

                }
            } else {
                cityName = it.getString(ARG_PARAM1)!!
                weatherState = it.getString(ARG_PARAM2)!!
            }

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_alert_pref, container, false)
        val f: NumberFormat = DecimalFormat("00")
        val btnAdd: FloatingActionButton = root.findViewById(R.id.f_btn_add_alert)
        val txtTo: TextView = root.findViewById(R.id.duration)
        val txtFrom: TextView = root.findViewById(R.id.from)
        val txtUnit: TextView = root.findViewById(R.id.pre_unit)
        val durationPicker: NumberPicker = root.findViewById(R.id.btn_to)
        val des: TextInputEditText = root.findViewById(R.id.edit_des)
        val btnFrom: Button = root.findViewById(R.id.btn_from)
        val days: MaterialDayPicker = root.findViewById(R.id.materialDayPicker)
        val numPicker: NumberPicker = root.findViewById(R.id.numberPicker)
        val timeR: RadioGroup = root.findViewById(R.id.timeRadio)
        val moreR: RadioGroup = root.findViewById(R.id.moreLessR)

        durationPicker.minValue = 0
        durationPicker.maxValue = 23
        durationPicker.value = duration
        btnFrom.setText("${f.format(from)}:00")
        des.setText(desc)
        if (list != null) {
            days.setSelectedDays(list!!)
        }
        if (!more) {
            moreR.check(R.id.LessThan)
        }

        if (from != 0 || duration != 23) {
            txtTo.visibility = View.VISIBLE
            txtFrom.visibility = View.VISIBLE
            durationPicker.visibility = View.VISIBLE
            btnFrom.visibility = View.VISIBLE
            timeR.check(R.id.period)
        }
        timeR.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.anytime) {
                txtTo.visibility = View.INVISIBLE
                txtFrom.visibility = View.INVISIBLE
                durationPicker.visibility = View.INVISIBLE
                btnFrom.visibility = View.INVISIBLE
            } else {
                from = 0
                duration = 23
                txtTo.visibility = View.VISIBLE
                txtFrom.visibility = View.VISIBLE
                durationPicker.visibility = View.VISIBLE
                btnFrom.visibility = View.VISIBLE
                btnFrom.text = "00:00"
                durationPicker.value = 0
            }

        }


        moreR.setOnCheckedChangeListener { _, checkedId ->
            more = (checkedId == R.id.moreThan)
        }

        durationPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            duration = newVal
        }

        numPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            unitCount = newVal
        }


        btnFrom.setOnClickListener {
            val timePickerDialog = TimePickerDialog(
                context,
                { _, hourOfDay, minute ->
                    btnFrom.text = "${f.format(hourOfDay)} : ${f.format(minute)}"
                    from = hourOfDay
                }, from, 0, false
            )
            timePickerDialog.show()
        }

        when (weatherState) {
            "cloud" -> {
                txtUnit.text = "%"
                numPicker.maxValue = 100
                numPicker.minValue = 0
                numPicker.value = unitCount

            }

            "temp" -> {
                txtUnit.text = "°C"
                numPicker.maxValue = 50
                numPicker.minValue = 0
                numPicker.value = unitCount

            }
            "wind" -> {
                txtUnit.text = "m/s"
                numPicker.maxValue = 20
                numPicker.minValue = 0
                numPicker.value = unitCount

            }
            else -> {
                moreR.visibility = View.INVISIBLE
                txtUnit.visibility = View.INVISIBLE
                numPicker.visibility = View.INVISIBLE
            }


        }


        btnAdd.setOnClickListener {
            CoroutineScope(job+Dispatchers.IO).launch {
                val rep = Repository.getInstance(application = requireActivity().application)
                if (update) {
                    updateObj?.listDays = List(days.selectedDays.size) { index ->
                        days.selectedDays[index].name
                    }
                    updateObj?.from = from
                    updateObj?.duration = duration
                    updateObj?.desc = des.text.toString()
                    updateObj?.more = more
                    updateObj?.unitCount = unitCount
                   rep.updateAlert(alertEntity = updateObj!!)
                } else {
                    rep.setAlert(
                        AlertEntity(
                            city = cityName,
                            weatherState = weatherState,
                            from = from,
                            duration = duration,
                            desc = des.text.toString(),
                            more = more,
                            unitCount = unitCount,
                            listDays = List(days.selectedDays.size) { index ->
                                days.selectedDays[index].name
                            },
                            notify = true
                        )
                    )
                }
                withContext(Dispatchers.Main) {
                    findNavController().popBackStack(R.id.Alert, false)
                }
            }
        }

        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
    }


}