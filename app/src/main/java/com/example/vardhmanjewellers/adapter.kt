package com.example.vardhmanjewellers

import Model.jewelrrydata
import activity.favorites
import activity.recyclerview
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
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.itemviewforrecyclerview.view.*
lateinit var db:FirebaseFirestore

class adapter(val context: Context, val ringlist: MutableList<jewelrrydata>): RecyclerView.Adapter<adapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemviewforrecyclerview, parent, false)

        return MyViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = ringlist[position]
        holder.ringname.text = currentitem.productname
        holder.weight.text = currentitem.weight
        Glide.with(context).load(currentitem.purl).into(holder.pic)



    }

    override fun getItemCount(): Int {
        return ringlist.size
    }

   inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val weight: TextView = itemView.findViewById(R.id.weight)

        val pic: ImageView = itemView.findViewById(R.id.jewelypic)
        val ringname: TextView = itemView.findViewById(R.id.productname)
        init {
            itemView.jewelypic.setOnClickListener {
                val intent=Intent(itemView.context, recyclerview::class.java)
             intent.putExtra("url",ringlist[adapterPosition].purl)
                intent.putExtra("ringname",ringname.text)
                intent.putExtra("weight",weight.text)
            startActivity(context,intent, Bundle.EMPTY)

            }


itemView.whislist.setOnClickListener{
    db= FirebaseFirestore.getInstance()
    val user:MutableMap<String,Any> =HashMap()
    user["productname"]=ringname.text.toString()
    user["purl"]=ringlist[adapterPosition].purl
    user["weight"]=weight.text.toString()
    db.collection("favcollection").document("${ringname.text}").set(user)
    val intent=Intent(itemView.context, favorites::class.java)



}


        }




    }
}




