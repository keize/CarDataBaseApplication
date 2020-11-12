package com.example.carsdatabaseapi.model

data class CarResponse(
    val Count: Int,
    val Message: String,
    val Results: List<Result>,
    val SearchCriteria: String
)