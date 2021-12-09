package activity

import Model.Itemvia
import Model.Topbrandsitem
import Model.sliderAdapter
import Model.slideritems
import adapter.myAdapter
import adapter.topbrandsAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.vardhmanjewellers.*
import com.example.vardhmanjewellers.databinding.ActivityFrontpageBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_frontpage.*
import kotlinx.android.synthetic.main.recyclerviewitems.*
import kotlin.math.abs

class frontpage : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    private lateinit var viewPager2: ViewPager2
    lateinit var actionBarDrawerToggle: ActionBarDrawerToggle
    lateinit var binding: ActivityFrontpageBinding
    lateinit var firestore: FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()
        binding = ActivityFrontpageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth= FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()
        binding.recyclerview.layoutManager =
            LinearLayoutManager(this@frontpage, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerview1.layoutManager =
            LinearLayoutManager(this@frontpage, LinearLayoutManager.HORIZONTAL, false)
        recyclersetup()
        recyclersetup1()
        setup()
        binding.cartid.setOnClickListener {
            val intent=Intent(this,AddToCart::class.java)
            startActivity(intent)
        }
        binding.favid.setOnClickListener {
            val intent=Intent(this,favorites::class.java)
            startActivity(intent)
        }
        autoscroll()
        binding.cartid.setOnClickListener {
            val intent=Intent(this,AddToCart::class.java)
            startActivity(intent)
        }
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

    private fun autoscroll() {
        viewPager2 = findViewById(R.id.viewpagerimage)
        val Slideritems: MutableList<slideritems> = ArrayList()
        Slideritems.add(slideritems(R.drawable.gold4))
        Slideritems.add(slideritems(R.drawable.gold5))
        Slideritems.add(slideritems(R.drawable.gold1))
        Slideritems.add(slideritems(R.drawable.gold2))
        Slideritems.add(slideritems(R.drawable.gold3))
        viewPager2.adapter = sliderAdapter(Slideritems, viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.25f

        }
        viewPager2.setPageTransformer(compositePageTransformer)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,3000)
            }
        })
    }
    private val handler=Handler()
    private val runnable= Runnable {
        viewPager2.currentItem=viewPager2.currentItem+1

    }


    private fun recyclersetup() {
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
    private fun recyclersetup1() {
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


    private fun logout() {
        auth.signOut()
       Intent(this@frontpage,intro::class.java).also {
           it.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
           startActivity(it)
       }
        Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show()
    }

    private fun switch() {
        val intent=Intent(this,login::class.java)
        startActivity(intent)
        Toast.makeText(this, "switch Account", Toast.LENGTH_SHORT).show()
    }

    private fun help() {
        Toast.makeText(this, "help", Toast.LENGTH_SHORT).show()
    }

    private fun rate() {
        val intent=Intent(this,lol::class.java)
        startActivity(intent)
        Toast.makeText(this, "Rate us", Toast.LENGTH_SHORT).show()
    }

    private fun profilefrag() {
        val intent=Intent(this, profile::class.java)
        startActivity(intent)
    }


    private fun setup() {
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