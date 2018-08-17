package com.example.vikaslandge.trainroute

import com.example.vikaslandge.trainroute.bean.TrainRouteBean
import retrofit2.Call
import retrofit2.http.GET

interface RouteAPI {
    @GET("v2/route/train/22107/apikey/souoboekaj/")
    fun getRouteInfo() : Call<TrainRouteBean>
}