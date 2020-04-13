package com.zwonb.sunnyweather.ui.place

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.zwonb.sunnyweather.MainActivity
import com.zwonb.sunnyweather.R
import com.zwonb.sunnyweather.ui.weather.WeatherActivity
import kotlinx.android.synthetic.main.fragment_place.*

/**
 *
 * @author zwonb
 * @date 2020/4/11
 */
class PlaceFragment : Fragment() {

    val viewModel by lazy { ViewModelProviders.of(this)[PlaceViewModel::class.java] }

    lateinit var adapter: PlaceAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_place, container,false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity is MainActivity && viewModel.isSavePlace()) {
            val place = viewModel.getSavePlace()
            val intent = Intent(context, WeatherActivity::class.java).apply {
                putExtra("location_lng", place.location.lng)
                putExtra("location_lat", place.location.lat)
                putExtra("place_name", place.name)
            }
            startActivity(intent)
            activity?.finish()
            return
        }

        val lm = LinearLayoutManager(context)
        recyclerView.layoutManager = lm
        adapter = PlaceAdapter(this, viewModel.placeList)
        recyclerView.adapter = adapter

        searchPlaceEdit.addTextChangedListener {
            val content = it?.toString()
            if (content.isNullOrEmpty()) {
                recyclerView.isGone = true
                bgImageView.isVisible = true
                viewModel.placeList.clear()
                adapter.notifyDataSetChanged()
            } else {
                viewModel.searchPlaces(content)
            }
        }

        viewModel.placeLiveData.observe(viewLifecycleOwner, Observer {
            val place = it.getOrNull()
            if (place != null) {
                recyclerView.isVisible = true
                bgImageView.isGone = true
                viewModel.placeList.clear()
                viewModel.placeList.addAll(place)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(activity, "未能查询到任何地点", Toast.LENGTH_SHORT).show()
                it.exceptionOrNull()?.printStackTrace()
            }
        })
    }

}