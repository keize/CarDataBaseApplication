package com.example.carsdatabaseapi.network

import com.example.carsdatabaseapi.model.CarResponse
import com.example.carsdatabaseapi.model.Result
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    // GET request to API

    @GET("honda?format=json")
    fun getcarList(): Call<CarResponse>

    @GET("honda?format=json")
    suspend fun getCarList1(): Response<CarResponse>

}