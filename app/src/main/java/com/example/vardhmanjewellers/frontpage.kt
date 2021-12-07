package com.example.vardhmanjewellers

import adapter.myAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vardhmanjewellers.databinding.ActivityFrontpageBinding
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_frontpage.*
import kotlinx.android.synthetic.main.recyclerviewitems.*

class frontpage : AppCompatActivity() {

    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityFrontpageBinding
    lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrontpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firestore = FirebaseFirestore.getInstance()
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this@frontpage, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerview1.layoutManager =
            LinearLayoutManager(this@frontpage, LinearLayoutManager.HORIZONTAL, false)
        recyclersetup()
        recyclersetup1()
        setup()
        bottomnav.setOnNavigationItemSelectedListener {
            (it.isChecked)
            when (it.itemId) {

            }
            true
        }

    }

        fun recyclersetup1() {
            firestore.collection("recyclecolln").get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(Topbrandsitem::class.java)
                        binding.recyclerview1.adapter = topbrandsAdapter(this, user)
                    }


                }
                .addOnFailureListener {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
        }

        fun recyclersetup() {
            firestore.collection("recyclercollection").get()
                .addOnSuccessListener { documents ->
                    for (document in documents) {
                        val user = documents.toObjects(Itemvia::class.java)
                        binding.recyclerview.adapter = myAdapter(this, user)
                    }


                }.addOnFailureListener {
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
                }
        }

        fun Homepage() {
            Toast.makeText(this, "home screen", Toast.LENGTH_SHORT).show()
        }

        fun collection() {

            Toast.makeText(this, "collection screen", Toast.LENGTH_SHORT).show()
        }

        fun logout() {            Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
        }

        fun switch() {
            Toast.makeText(this, "switch Account", Toast.LENGTH_SHORT).show()
        }

        fun help() {
            Toast.makeText(this, "help", Toast.LENGTH_SHORT).show()
        }

        fun rate() {
            Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show()
        }

        fun profilefrag() {
            Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
        }


        fun setup() {
            actionBarDrawerToggle =
                ActionBarDrawerToggle(this, abc, R.string.app_name, R.string.app_name)
            actionBarDrawerToggle.syncState()
            setSupportActionBar(goli)

        }

        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
                return true
            }
            return super.onOptionsItemSelected(item)
        }

}
