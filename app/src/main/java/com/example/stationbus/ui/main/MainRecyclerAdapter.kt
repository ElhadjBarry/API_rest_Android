package com.example.stationbus.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.RatingBar
import android.widget.TextView

import com.example.stationbus.R
import com.example.stationbus.data.Bus
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainRecyclerAdapter(val context : Context,
                          val bus: List<Bus>):
    RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    inner class ViewHolder(itemView : View):
            RecyclerView.ViewHolder(itemView){
        val nameText = itemView.findViewById<TextView>(R.id.nameText)
        //val BusImage = itemView.findViewById<TextView>(R.id.BusImage)
       //val raitingBar = itemView.findViewById<RatingBar>(R.id.raitingBar)

}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.bus_grid_item , parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = bus.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bus = bus[position]
        with(holder){
            nameText?.let {
                it.text =bus.city
                it.contentDescription=bus.distance
            }
            //ratingBar?.raiting=bus.distance.toFloat()

        }
        TODO("Not yet implemented")
    }


}