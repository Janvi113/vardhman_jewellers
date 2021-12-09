package adapter

import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vardhmanjewellers.R
import Model.favmembers
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.itemviewforcart.view.*

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
   inner class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val productname:TextView=itemView.findViewById(R.id.productnamecart)
        val weight:TextView=itemView.findViewById(R.id.cartweight)
        val pic:ImageView=itemView.findViewById(R.id.cartimage)
        init {
            itemView.deletedata.setOnClickListener {
                Toast.makeText(context,"removed", Toast.LENGTH_SHORT).show()
                db1= FirebaseFirestore.getInstance()
                val user:MutableMap<String,Any> =HashMap()
                user["productname"]=productname.text.toString()
                user["purl"]=fullfavitems[adapterPosition].purl
                user["weight"]=weight.text.toString()
                db1.collection("favcollection").document("${productname.text}").delete()



            }
        }

    }


}