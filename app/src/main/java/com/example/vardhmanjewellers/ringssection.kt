package com.example.vardhmanjewellers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vardhmanjewellers.databinding.ActivityRingssectionBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.*
import kotlinx.android.synthetic.main.activity_recyclerview.*

class ringssection : AppCompatActivity() {
    lateinit var dbred: DatabaseReference
    lateinit var orecyclerview: RecyclerView
    lateinit var adapter:adapter
    lateinit var binding: ActivityRingssectionBinding
    lateinit var db: FirebaseFirestore
    lateinit var arrylist: ArrayList<jewelrrydata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRingssectionBinding.inflate(layoutInflater)

        setContentView(binding.root)


       binding.recyclererre.layoutManager=GridLayoutManager(this,2)
        db = FirebaseFirestore.getInstance()
        getdata()
        val x=intent.getStringExtra("shrenu")

    }

    private fun getdata() {

        db.collection("goldrings").get().addOnSuccessListener {

                documents ->


            for (document in documents) {
                val user = documents.toObjects(jewelrrydata::class.java)
                binding.recyclererre.adapter = adapter(this, user)


            }
        }








    }
}



