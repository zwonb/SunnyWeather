package com.zwonb.sunnyweather.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.zwonb.sunnyweather.SunnyWeatherApplication
import com.zwonb.sunnyweather.logic.model.Place

/**
 * @author zwonb
 * @date 2020/4/13
 */
object PlaceDao {

    fun savePlace(place: Place) {
        sharedPreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavePlace(): Place {
        return Gson().fromJson(sharedPreferences().getString("place", ""), Place::class.java)
    }

    fun isSavePlace() = sharedPreferences().contains("place")

    private fun sharedPreferences() =
        SunnyWeatherApplication.context.getSharedPreferences("sunny_weather", Context.MODE_PRIVATE)

}