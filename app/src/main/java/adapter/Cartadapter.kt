package adapter

import android.content.Context
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vardhmanjewellers.R
import Model.cartmembers
import android.util.Log
import android.widget.Toast
import com.example.vardhmanjewellers.db
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_to_cart.*
import kotlinx.android.synthetic.main.itemviewforcart.view.*
import kotlin.coroutines.coroutineContext
lateinit var db1:FirebaseFirestore


class cartadapter(val context: Context,val fullcartitems:List<cartmembers>):RecyclerView.Adapter<cartadapter.myviewholder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder {
        val itemview = LayoutInflater.from(parent.context)
            .inflate(R.layout.itemviewforcart, parent, false)
        return myviewholder(itemview)

    }

    override fun onBindViewHolder(holder: myviewholder, position: Int) {

        val currentitem=fullcartitems[position]
        holder.productname.text=currentitem.productname
        holder.weight.text=currentitem.weight
        Glide.with(context).load(currentitem.purl).into(holder.pic)
    }

    override fun getItemCount(): Int {
     return  fullcartitems.size
    }
  inner  class myviewholder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val productname:TextView=itemView.findViewById(R.id.productnamecart)
        val weight:TextView=itemView.findViewById(R.id.cartweight)
        val pic:ImageView=itemView.findViewById(R.id.cartimage)
        val x=productname.text.toString()

        init {
            itemView.deletedata.setOnClickListener {
                Toast.makeText(context,"removed", Toast.LENGTH_SHORT).show()
                db1= FirebaseFirestore.getInstance()
                val user:MutableMap<String,Any> =HashMap()
                user["productname"]=productname.text.toString()
                user["purl"]=fullcartitems[adapterPosition].purl
                user["weight"]=weight.text.toString()
                db1.collection("addtocart").document("${productname.text}").delete()



            }
        }








        }

    }


