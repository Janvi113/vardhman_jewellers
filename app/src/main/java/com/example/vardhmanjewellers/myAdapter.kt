package adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vardhmanjewellers.Itemvia

import com.example.vardhmanjewellers.R
import com.example.vardhmanjewellers.ringssection
import kotlinx.android.synthetic.main.recyclerviewitems.view.*


class myAdapter(private val context: Context, private val items: MutableList<Itemvia>): RecyclerView.Adapter<myAdapter.myviewholder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitems,parent,false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
      //  holder.imageitem.setImageResource(icon.iconic())
        val user=items[position]
        holder.textitem.text=user.name
        Glide.with(context)
            .load(user.image).into(holder.imageitem)

    }

    override fun getItemCount(): Int {
        return items.size

    }


    class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageitem=itemView.findViewById<ImageView>(R.id.circleimage)
        val textitem=itemView.findViewById<TextView>(R.id.textitem)

        init{
            itemView.circleimage.setOnClickListener {
               val intent=Intent(itemView.context,ringssection::class.java)
                intent.putExtra("shrenu",textitem.text)
              startActivity(itemView.context, intent, Bundle.EMPTY)
            }
        }
    }

}