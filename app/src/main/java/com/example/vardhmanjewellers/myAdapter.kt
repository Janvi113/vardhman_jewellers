package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.vardhmanjewellers.Itemvia
import com.example.vardhmanjewellers.R
import de.hdodenhof.circleimageview.CircleImageView


class myAdapter(val context: Context,val items: List<Itemvia>): RecyclerView.Adapter<myAdapter.myviewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewitems,parent,false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {
        holder.imageitem.setImageResource(icon.iconic())
        holder.textitem.text=items[position].title


    }

    override fun getItemCount(): Int {
        return items.size

    }


    class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textitem=itemView.findViewById<TextView>(R.id.textitem)
        val imageitem=itemView.findViewById<CircleImageView>(R.id.circleimage)


    }

}