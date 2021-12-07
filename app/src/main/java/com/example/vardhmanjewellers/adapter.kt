package com.example.vardhmanjewellers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.common.collect.Iterables.size
import kotlinx.coroutines.processNextEventInCurrentThread
import java.nio.file.Files.size

class adapter(val context: Context,val ringlist:List<jewelrrydata>): RecyclerView.Adapter<adapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemview=LayoutInflater.from(parent.context).inflate(R.layout.itemviewforrecyclerview,parent,false)
        return  MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      val currentitem=ringlist[position]
        holder.ringname.text=currentitem.ringname
        holder.weight.text=currentitem.weight
        Glide.with(context).load(currentitem.purl).into(holder.pic)



    }

    override fun getItemCount(): Int {
        return ringlist.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val weight:TextView= itemView.findViewById(R.id.weight)
        val pic:ImageView= itemView.findViewById(R.id.jewelypic)
        val ringname:TextView= itemView.findViewById(R.id.productname)

    }

}


