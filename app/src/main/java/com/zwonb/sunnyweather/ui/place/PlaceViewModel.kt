package com.zwonb.sunnyweather.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.zwonb.sunnyweather.logic.Repository
import com.zwonb.sunnyweather.logic.model.Place

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
class PlaceViewModel : ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeList = arrayListOf<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) {
        Repository.savePlace(place)
    }

    fun getSavePlace() = Repository.getSavePlace()

    fun isSavePlace() = Repository.isSavePlace()

}