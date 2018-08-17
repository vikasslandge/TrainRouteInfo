package com.example.vikaslandge.trainroute.bean

data class Route(
        val schdep: String,
        val halt: Int,
        val distance: Int,
        val no: Int,
        val day: Int,
        val station: Station,
        val scharr: String
)