package com.example.vardhmanjewellers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_ringssection.*

class ringssection : AppCompatActivity() {
    lateinit var dbred: DatabaseReference
    lateinit var orecyclerview: RecyclerView
    lateinit var myadapter: adapter
    lateinit var db: FirebaseFirestore
    lateinit var arrylist: ArrayList<jewelrrydata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringssection)
        orecyclerview = findViewById(R.id.recyclererre)
        orecyclerview.setHasFixedSize(true)
        orecyclerview.layoutManager = LinearLayoutManager(this)
        arrylist = arrayListOf()
        myadapter = adapter(this, arrylist)
        orecyclerview.adapter=myadapter
        EventChangeListener()
    }
    private fun EventChangeListener(){
        db= FirebaseFirestore.getInstance()
        db.collection("goldrings").addSnapshotListener(object :EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException?) {
                if (error != null)
                    Toast.makeText(this@ringssection, "54354", Toast.LENGTH_SHORT).show()
               for (dc : DocumentChange in value?.documentChanges!!){

                   if(dc.type==DocumentChange.Type.ADDED){
                       arrylist.add(dc.document.toObject(jewelrrydata::class.java))
                   }
               }
                myadapter.notifyDataSetChanged()

            }




        })
    }
}

