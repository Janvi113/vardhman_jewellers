package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vardhmanjewellers.adapter
import com.example.vardhmanjewellers.databinding.ActivityRingssectionBinding
import Model.jewelrrydata
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.*

class ringssection : AppCompatActivity() {
    lateinit var dbred: DatabaseReference
    lateinit var orecyclerview: RecyclerView
    lateinit var myadapter: adapter
    lateinit var binding: ActivityRingssectionBinding
    lateinit var db: FirebaseFirestore
    lateinit var arrylist: ArrayList<jewelrrydata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRingssectionBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // setContentView(R.layout.activity_ringssection)
       binding.recyclererre.layoutManager=GridLayoutManager(this,2)
        db = FirebaseFirestore.getInstance()
        getdata()

    }

    private fun getdata() {
        val joker=intent.getStringExtra("shrenu")

        db.collection("$joker").get().addOnSuccessListener { documents ->

            for (document in documents) {
                val user = documents.toObjects(jewelrrydata::class.java)
                binding.recyclererre.adapter = adapter(this, user)


            }
        }








    }
}



