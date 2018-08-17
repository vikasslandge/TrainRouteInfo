package com.example.vikaslandge.trainroute.bean

data class Train(
        val classes: List<Classe>,
        val days: List<Day>,
        val number: String,
        val name: String
)