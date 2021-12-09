package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vardhmanjewellers.R
import Model.Topbrandsitem
import kotlinx.android.synthetic.main.recycleritem1.view.*


class topbrandsAdapter(val context: Context, val topbrands: List<Topbrandsitem>): RecyclerView.Adapter<topbrandsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.recycleritem1,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
     val user=topbrands[position]
        holder.topbranddes.text=user.description
        holder.topbrandtext.text=user.price
        Glide.with(context)
            .load(user.image)
            .into(holder.topbrandimage)
    }

    override fun getItemCount(): Int {
        return topbrands.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val topbrandimage=itemView.findViewById<ImageView>(R.id.topbrandimage)
        val topbrandtext=itemView.findViewById<TextView>(R.id.topbrandprice)
        val topbranddes=itemView.findViewById<TextView>(R.id.topbranddes)



    }

}