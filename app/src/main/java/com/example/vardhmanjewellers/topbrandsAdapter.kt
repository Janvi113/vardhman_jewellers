package com.example.vardhmanjewellers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView




class topbrandsAdapter(val context: Context,val topbrands: List<Topbrandsitem>): RecyclerView.Adapter<topbrandsAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycleritem1,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.topbrandimages.setImageResource(icon.topbrandsicon())
        holder.topbrandtext.text=topbrands[position].rate
        holder.topbranddes.text=topbrands[position].description
    }

    override fun getItemCount(): Int {
        return topbrands.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topbrandimages=itemView.findViewById<ImageView>(R.id.topbrandimage)
        val topbrandtext=itemView.findViewById<TextView>(R.id.topbrandprice)
        val topbranddes=itemView.findViewById<TextView>(R.id.topbranddes)
    }

}