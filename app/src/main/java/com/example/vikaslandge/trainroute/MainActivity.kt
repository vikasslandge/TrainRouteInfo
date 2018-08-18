package com.example.vikaslandge.trainroute

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.isEmpty
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.vikaslandge.trainroute.bean.TrainRouteBean
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        b1.setOnClickListener {
            if (!et1.text.toString().isEmpty()) {
                var r = Retrofit.Builder().baseUrl("https://api.railwayapi.com/").addConverterFactory(GsonConverterFactory.create()).build()

                var api = r.create(RouteAPI::class.java)
                var call = api.getRouteInfo(et1.text.toString())
                call.enqueue(object : Callback<TrainRouteBean> {
                    override fun onFailure(call: Call<TrainRouteBean>?, t: Throwable?) {

                        Toast.makeText(this@MainActivity, "plz try again", Toast.LENGTH_LONG).show()


                    }

                    override fun onResponse(call: Call<TrainRouteBean>?, response: Response<TrainRouteBean>?) {
                        var bean = response!!.body()
                        var list = mutableListOf<String>()
                        list.add("Train Name : " + bean!!.train.name + "\nTrain Number : " + bean!!.train.number)

                        var route = bean!!.route
                        for (d in route) {
                            list.add("Station name : " + d.station.name + "\nStation code : " + d.station.code +
                                    "\nschedule arr : " + d.scharr + "\nschedule dep : " + d.schdep)
                            // list.add("Station code : "+d.station.code)

                        }

                        var days = bean!!.train.days
                        for (d in days) {
                            list.add("Days : " + d.code + "\nruns :" + d.runs)
                        }

                        var adapter = ArrayAdapter(this@MainActivity, android.R.layout.select_dialog_item, list)
                        lview.adapter = adapter
                    }
                })

            }else{
                Toast.makeText(this,"enter train no",Toast.LENGTH_LONG).show()
            }
        }
    }
}
