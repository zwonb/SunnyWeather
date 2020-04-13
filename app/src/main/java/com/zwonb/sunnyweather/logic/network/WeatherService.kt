package com.zwonb.sunnyweather.logic.network

import com.zwonb.sunnyweather.SunnyWeatherApplication
import com.zwonb.sunnyweather.logic.model.DailyResponse
import com.zwonb.sunnyweather.logic.model.RealtimeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @author zwonb
 * @date 2020/4/13
 */
interface WeatherService {

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/realtime.json")
    suspend fun getRealtimeWeather(
        @Path("lng") lng: String,
        @Path("lat") lat: String
    ): RealtimeResponse

    @GET("v2.5/${SunnyWeatherApplication.TOKEN}/{lng},{lat}/daily.json")
    suspend fun getDailyWeather(@Path("lng") lng: String, @Path("lat") lat: String): DailyResponse

}