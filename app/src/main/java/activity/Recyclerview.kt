package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.vardhmanjewellers.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_recyclerview.*

class recyclerview : AppCompatActivity() {
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var i=1

        setContentView(R.layout.activity_recyclerview)

        add.setOnClickListener(){
            i=i+1
            amount.text="$i"
        }
        subtract.setOnClickListener(){
            if(i>=2)
            {
                i=i-1
                amount.text="$i"
            }

        }
        val title=intent.getStringExtra("ringname").toString()
        val purl=intent.getStringExtra("url").toString()
        val wei=intent.getStringExtra("weight").toString()
     textView3.text= intent.getStringExtra("ringname")

        weit.text=wei
        Glide.with(this).load(purl).into(imageView3)
        addtocart.setOnClickListener{
val intent1=Intent(this, AddToCart::class.java)
            intent1.putExtra("productname",title)
            intent1.putExtra("url",purl)
            intent1.putExtra("weight",wei)
            adddatatocart(title,purl,wei)



        }



    }

    private fun adddatatocart(productname:String,purl:String,weight:String) {
        db= FirebaseFirestore.getInstance()
        val user:MutableMap<String,Any> =HashMap()
        user["productname"]=productname
        user["purl"]=purl
        user["weight"]=weight
        db.collection("addtocart").add(user)


    }
}