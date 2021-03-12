package com.weatherintake41itiahy.weather.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.mainScreenUI.mainActivity.MainActivity
import kotlinx.coroutines.*

class Splash : AppCompatActivity() {
    private val job= Job()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        CoroutineScope(job+Dispatchers.Default).launch{
            delay(3000)
            withContext(Dispatchers.Main){
                val intent=Intent(this@Splash,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}