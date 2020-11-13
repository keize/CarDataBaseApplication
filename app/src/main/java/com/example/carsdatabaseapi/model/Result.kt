package com.example.carsdatabaseapi.model

import com.google.gson.annotations.SerializedName

data class Result(

    // data model from JSON with Retrofit annotation

    @SerializedName("Make_ID")
    val Make_ID: Int,

    @SerializedName("Make_Name")
    val Make_Name: String,

    @SerializedName("Model_ID")
    val Model_ID: Int,

    @SerializedName("Model_Name")
    val Model_Name: String

)