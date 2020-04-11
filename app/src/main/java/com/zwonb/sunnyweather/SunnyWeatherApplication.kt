package com.zwonb.sunnyweather

import android.app.Application
import android.content.Context

/**
 * application
 *
 * @author zwonb
 * @date 2020/4/11
 */

class SunnyWeatherApplication : Application() {

    companion object {
        lateinit var context: Context
        const val TOKEN = "TODO"
    }

    override fun onCreate() {
        super.onCreate()

        context = applicationContext
    }
}