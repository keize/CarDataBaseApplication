package com.example.carsdatabaseapi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carsdatabaseapi.R
import com.example.carsdatabaseapi.model.Result

class CarAdapter(var carList: List<Result>, val context: Context) : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
         val view = LayoutInflater.from(context).inflate(R.layout.activity_item, parent, false)
         return CarViewHolder(view)
     }

     override fun onBindViewHolder(holder: CarViewHolder, position: Int) {
         val carModel = carList[position]
         holder.brandText.text = carModel.Make_Name
         holder.modelText.text = carModel.Model_Name
         holder.brandID.text = carModel.Make_ID.toString()
         holder.modelID.text = carModel.Model_ID.toString()

     }

     override fun getItemCount(): Int {
         return carList.size
     }

     inner class CarViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

         var brandText = itemView.findViewById<TextView>(R.id.tv_brand)
         var modelText = itemView.findViewById<TextView>(R.id.tv_model)
         var brandID = itemView.findViewById<TextView>(R.id.tv_brandID)
         var modelID = itemView.findViewById<TextView>(R.id.tv_modelID)


     }


 }

