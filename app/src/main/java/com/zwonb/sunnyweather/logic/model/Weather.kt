package com.zwonb.sunnyweather.logic.model

/**
 * @author zwonb
 * @date 2020/4/13
 */
data class Weather(val realtime: RealtimeResponse.Realtime, val daily: DailyResponse.Daily)