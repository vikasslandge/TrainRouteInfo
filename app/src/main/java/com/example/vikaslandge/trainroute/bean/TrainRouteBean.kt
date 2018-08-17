package com.example.vikaslandge.trainroute.bean

data class TrainRouteBean(
        val debit: Int,
        val train: Train,
        val route: List<Route>,
        val response_code: Int
)