package com.example.vardhmanjewellers

import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class favadapter(val context: Context,val fullfavitems:List<favmembers>):RecyclerView.Adapter<favadapter.myviewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemviewforcart, parent, false)
        return myviewholder(itemview)

    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {

        val currentitem=fullfavitems[position]
        holder.productname.text=currentitem.productname
        holder.weight.text=currentitem.weight
        Glide.with(context).load(currentitem.purl).into(holder.pic)
    }

    override fun getItemCount(): Int {
        return  fullfavitems.size
    }
    class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val productname:TextView=itemView.findViewById(R.id.productnamecart)
        val weight:TextView=itemView.findViewById(R.id.cartweight)
        val pic:ImageView=itemView.findViewById(R.id.cartimage)

    }


}