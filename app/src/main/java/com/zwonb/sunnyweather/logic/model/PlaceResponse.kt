package com.zwonb.sunnyweather.logic.model

import com.google.gson.annotations.SerializedName

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
data class PlaceResponse(val status: String, val places: List<Place>)

data class Place(
    val name: String, val location: Location,
    @SerializedName("formatted_address") val address: String
)

data class Location(val lng: String, val lat: String)
