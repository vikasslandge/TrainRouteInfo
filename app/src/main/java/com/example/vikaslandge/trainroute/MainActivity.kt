package com.example.vikaslandge.trainroute

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            var r = Retrofit.Builder().
                    baseUrl("https://railwayapi.com/").
                    addConverterFactory(GsonConverterFactory.create()).build()

            r.

        }
    }
}
