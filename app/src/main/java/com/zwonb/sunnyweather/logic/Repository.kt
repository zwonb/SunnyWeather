package com.zwonb.sunnyweather.logic

import androidx.lifecycle.liveData
import com.zwonb.sunnyweather.logic.model.Place
import com.zwonb.sunnyweather.logic.network.SunnyWeatherNetwork
import kotlinx.coroutines.Dispatchers

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = SunnyWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                Result.success<List<Place>>(placeResponse.places)
            } else {
                Result.failure<List<Place>>(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}