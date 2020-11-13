package com.example.carsdatabaseapi.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.carsdatabaseapi.R
import com.example.carsdatabaseapi.SecondActivity
import com.example.carsdatabaseapi.model.Result

class CarAdapter(var carList: List<Result>, val context: Context) :
    RecyclerView.Adapter<CarAdapter.CarViewHolder>() {


    // set item_layout to recyclerview in fun onCreateViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return CarViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarViewHolder, position: Int) {

        // set data to views

        val carModel = carList[position]
        holder.brandText.text = carModel.Make_Name
        holder.modelText.text = carModel.Model_Name
        holder.brandID.text = carModel.Make_ID.toString()
        holder.modelID.text = carModel.Model_ID.toString()


        // set click event on item

        holder.itemView.setOnClickListener() {
            val intent = Intent(this.context, SecondActivity::class.java)

            intent.putExtra("brandText", carModel.Make_Name)
            intent.putExtra("modelText", carModel.Model_Name)
            holder.itemView.context.startActivity(intent)
            Log.d("clicksend", carModel.Model_Name)  // check my intent send info



        }

    }

    override fun getItemCount(): Int {
        return carList.size
    }

    inner class CarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // set views in item_activity

        var brandText = itemView.findViewById<TextView>(R.id.tv_brand)
        var modelText = itemView.findViewById<TextView>(R.id.tv_model)
        var brandID = itemView.findViewById<TextView>(R.id.tv_brandID)
        var modelID = itemView.findViewById<TextView>(R.id.tv_modelID)



    }
}

