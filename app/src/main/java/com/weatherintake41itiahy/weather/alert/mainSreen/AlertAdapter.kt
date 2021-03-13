package com.weatherintake41itiahy.weather.alert.mainSreen

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.weatherintake41itiahy.weather.Local.LocalLang
import com.weatherintake41itiahy.weather.R

import com.weatherintake41itiahy.weather.model.entity.AlertEntity
import java.lang.StringBuilder

class AlertAdapter(private val viewModel: AlertViewModel) :
    RecyclerView.Adapter<AlertAdapter.Holder>() {

    private var list: MutableList<AlertEntity>? = null

    fun setData(alertEntity: List<AlertEntity>) {
        list = alertEntity as MutableList<AlertEntity>
    }
    fun deleteItem(position: Int):AlertEntity{
        return list?.removeAt(position)!!
    }
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val city: TextView = itemView.findViewById(R.id.alert_weather_city)
        private val des: TextView = itemView.findViewById(R.id.alert_desc)
        private val fromDuration: TextView = itemView.findViewById(R.id.from_to_and_custom)
        private val days: TextView = itemView.findViewById(R.id.txt_alert_days)
        private val edit: ImageView = itemView.findViewById(R.id.btn_edit_alert)
        private val notifi: ImageView = itemView.findViewById(R.id.btn_notification_alrt)
        fun bind(alertEntity: AlertEntity, context: Context, viewModel: AlertViewModel) {
            city.text = alertEntity.city
            des.text = alertEntity.desc
            fromDuration.text =
                "${context.getString(R.string.from)} ${alertEntity.from} \n" +
                        "${context.getString(R.string.duration)} = " +
                        "${alertEntity.duration} \n${context.getString(R.string.check)} " +
                        "${context.getString(LocalLang.getMainWeatherAlert(alertEntity.weatherState))}"
            val st = StringBuilder()
            for (I in alertEntity.listDays) {
                st.append(I).append(" , ")
            }

            days.text = st.toString()
            itemView.animation =
                AnimationUtils.loadAnimation(context, R.anim.item_animation_fall_down)
            edit.setOnClickListener {
                viewModel.onPassData(alertEntity)
            }
            if (alertEntity.notify) {
                notifi.setImageResource(R.drawable.notifi_ic_30)
            } else {
                notifi.setImageResource(R.drawable.no_notifi_ic_30)
            }
            notifi.setOnClickListener {
                alertEntity.notify = !alertEntity.notify
                viewModel.updateAlert(alertEntity)
            }
        }
    }

    var context: Context? = null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alert_co, parent, false)

        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list!![position], context!!, viewModel)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}