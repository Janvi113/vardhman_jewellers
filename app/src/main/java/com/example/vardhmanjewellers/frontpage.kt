package com.example.vardhmanjewellers

import adapter.myAdapter
import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_frontpage.*

class frontpage : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: myAdapter
    lateinit var recyclerView1: RecyclerView
    lateinit var adapter1: topbrandsAdapter
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    var colln = mutableListOf<Itemvia>()
    var colln1 = mutableListOf<Topbrandsitem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frontpage)
        setuprecyclerview()
        setuprecyclerview1()
        setup()
        dummy()
        dummy1()
        bottomnav.setOnNavigationItemSelectedListener {
            (it.isChecked)
            when (it.itemId) {

            }
            true
        }


        nav_view.setNavigationItemSelectedListener {
            it.isChecked = true
            when (it.itemId) {
                R.id.profileid -> profilefrag()
                R.id.rateid -> rate()
                R.id.helpid -> help()
                R.id.switchaccountid -> switch()
                R.id.logoutid -> logout()
            }
            true
        }

    }

    private fun showcase(str: String) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show()
    }

    private fun Homepage() {
        Toast.makeText(this, "home screen", Toast.LENGTH_SHORT).show()
    }

    private fun collection() {

        Toast.makeText(this, "collection screen", Toast.LENGTH_SHORT).show()
    }

    private fun logout() {
        Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
    }

    private fun switch() {
        Toast.makeText(this, "switch Account", Toast.LENGTH_SHORT).show()
    }

    private fun help() {
        Toast.makeText(this, "help", Toast.LENGTH_SHORT).show()
    }

    private fun rate() {
        Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show()
    }

    private fun profilefrag() {
        Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
    }

    private fun setuprecyclerview1() {
        recyclerView1 = findViewById(R.id.recyclerview1)
        adapter1 = topbrandsAdapter(this, colln1)
        recyclerView1.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView1.adapter = adapter1
    }


    private fun dummy1() {
        colln1.add(Topbrandsitem("$50,000", "Spiritual 22 karat gold\n om ring"))
        colln1.add(Topbrandsitem("$33,194", "charming 950 pure\nplatinum and\nDiamond flora studs"))
        colln1.add(Topbrandsitem("$39,678", "Bold 22 karat Yellow\nGold Geometric Ring"))
        colln1.add(Topbrandsitem("$33,836", "Elegant Gold Mang\nTikka"))
    }

    private fun dummy() {
        colln.add(Itemvia("Ring"))
        colln.add(Itemvia("Necklaces"))
        colln.add(Itemvia("Earings"))
        colln.add(Itemvia("Bangles"))
        colln.add(Itemvia("Anklet"))
    }

    private fun setup() {
        actionBarDrawerToggle =
            ActionBarDrawerToggle(this, abc, R.string.app_name, R.string.app_name)
     actionBarDrawerToggle.syncState()
        setSupportActionBar(goli)

}


    @SuppressLint("WrongConstant")
    private fun setuprecyclerview() {
        recyclerView=findViewById(R.id.recyclerview)
        adapter=myAdapter(this,colln)
        recyclerView.layoutManager=LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter=adapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    }
