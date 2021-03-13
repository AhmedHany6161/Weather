package com.weatherintake41itiahy.weather.splash

import android.annotation.SuppressLint
import android.app.DownloadManager
import android.content.ComponentName
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.weatherintake41itiahy.weather.R
import com.weatherintake41itiahy.weather.mainScreenUI.mainActivity.MainActivity
import kotlinx.coroutines.*

class Splash : AppCompatActivity() {
    private val job = Job()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_splash)
        val perm = Intent()
        when (android.os.Build.MANUFACTURER) {
            "xiaomi" ->
                perm.component =
                    ComponentName(
                        "com.miui.securitycenter",
                        "com.miui.permcenter.autostart.AutoStartManagementActivity"
                    )
            "oppo" ->
                perm.component =
                    ComponentName(
                        "com.coloros.safecenter",
                        "com.coloros.safecenter.permission.startup.StartupAppListActivity"
                    )
            "vivo" ->
                perm.component =
                    ComponentName(
                        "com.vivo.permissionmanager",
                        "com.vivo.permissionmanager.activity.BgStartUpManagerActivity"
                    )
        }
        val list = packageManager.queryIntentActivities(perm, PackageManager.MATCH_DEFAULT_ONLY)
        if (list.size > 0) {
            startActivity(perm)
        }
        CoroutineScope(job + Dispatchers.Default).launch {
            delay(2000)
            withContext(Dispatchers.Main) {
                val intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}