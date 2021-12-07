package com.example.vardhmanjewellers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.common.collect.Iterables.size
import kotlinx.android.synthetic.main.itemviewforrecyclerview.view.*
import kotlinx.coroutines.processNextEventInCurrentThread
import java.nio.file.Files.size
import kotlin.math.log

class adapter(val context: Context,val ringlist:List<jewelrrydata>): RecyclerView.Adapter<adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemviewforrecyclerview, parent, false)

        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = ringlist[position]
        holder.ringname.text = currentitem.ringname
        holder.weight.text = currentitem.weight
        Glide.with(context).load(currentitem.purl).into(holder.pic)



    }

    override fun getItemCount(): Int {
        return ringlist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val weight: TextView = itemView.findViewById(R.id.weight)

        val pic: ImageView = itemView.findViewById(R.id.jewelypic)
        val ringname: TextView = itemView.findViewById(R.id.productname)
        init {
            itemView.jewelypic.setOnClickListener {
                val intent=Intent(itemView.context,recyclerview::class.java)
                intent.putExtra("yoyo",ringname.text)
                startActivity(itemView.context,intent, Bundle.EMPTY)
            }
        }


    }
}




