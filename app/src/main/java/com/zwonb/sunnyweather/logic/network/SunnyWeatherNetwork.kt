package com.zwonb.sunnyweather.logic.network

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
object SunnyWeatherNetwork {

    private val placeService = ServiceCreator.create<PlaceService>()

    suspend fun searchPlaces(query: String) = placeService.searchPlaces(query)

}