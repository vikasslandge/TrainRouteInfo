package com.example.vikaslandge.trainroute

import com.example.vikaslandge.trainroute.bean.TrainRouteBean
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RouteAPI {
    @GET("v2/route/train/{trainno}/apikey/souoboekaj/")
    fun getRouteInfo(@Path("trainno") trainno:String) : Call<TrainRouteBean>
}

 

