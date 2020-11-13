package com.example.carsdatabaseapi.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {

        //create Retrofit connection with base api url

        private val BASE_URL = "https://vpic.nhtsa.dot.gov/api/vehicles/getmodelsformake/"
        fun getRestEngine(): ApiInterface {
            val client = OkHttpClient.Builder().build()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}