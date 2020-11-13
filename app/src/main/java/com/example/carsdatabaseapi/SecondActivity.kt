package com.example.carsdatabaseapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //get data from Adapter

        var brandText2 = intent.getStringExtra("brandText")
        var modelText2 = intent.getStringExtra("modelText")

        tv2_model.text = brandText2
        tv2_brand.text = modelText2

    }

}