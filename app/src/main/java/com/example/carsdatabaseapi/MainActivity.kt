package com.example.carsdatabaseapi

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.carsdatabaseapi.adapter.CarAdapter
import com.example.carsdatabaseapi.model.CarResponse
import com.example.carsdatabaseapi.model.Result
import com.example.carsdatabaseapi.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var navController: NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getCars()
    }


    fun getCars() {
        ApiClient.getRestEngine().getcarList()
            .enqueue(object : Callback<CarResponse> {
                override fun onResponse(call: Call<CarResponse>, response: Response<CarResponse>) {
                    if (response.code() == 200) {
                        println(response.body())
                        var listOfCars: List<Result> = response.body()?.Results!!
                        val adapter = CarAdapter(listOfCars, this@MainActivity)

                        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                        recyclerView.setHasFixedSize(true)
                        recyclerView.adapter = adapter
                        adapter.notifyDataSetChanged();
                    }
                }

                override fun onFailure(call: Call<CarResponse>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Work without INTERNET", Toast.LENGTH_SHORT)
                        .show()

                    //create data for connection without Internet

                    val carsFailureList = ArrayList<Result>()
                    carsFailureList.add(Result(3434, "BMW", 1, "A5"))
                    carsFailureList.add(Result(3434, "AUDI", 2, "A3"))
                    carsFailureList.add(Result(3434, "Chery", 1, "QQ"))
                    carsFailureList.add(Result(3434, "ZAZ", 2, "9120"))
                    carsFailureList.add(Result(3434, "WV", 1, "Jetta"))

                    val adapter = CarAdapter(carsFailureList, this@MainActivity)

                    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    recyclerView.setHasFixedSize(true)
                    recyclerView.adapter = adapter
                    adapter.notifyDataSetChanged()

                }
            })
    }

    override fun onRestart() {
        super.onRestart()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent) // Always call the superclass method first

        // Activity being restarted from stopped state
    }
}





