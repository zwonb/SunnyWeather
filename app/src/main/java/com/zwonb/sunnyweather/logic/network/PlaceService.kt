package com.zwonb.sunnyweather.logic.network

import com.zwonb.sunnyweather.SunnyWeatherApplication
import com.zwonb.sunnyweather.logic.model.PlaceResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
interface PlaceService {

    @GET("v2/place?token=${SunnyWeatherApplication.TOKEN}&lang=zh_CN")
    suspend fun searchPlaces(@Query("query") query: String): PlaceResponse
}