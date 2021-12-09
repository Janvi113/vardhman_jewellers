package activity

import Model.sliderAdapter
import Model.slideritems
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.core.view.OneShotPreDrawListener.add
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.example.vardhmanjewellers.R
import kotlinx.android.synthetic.main.activity_lol.*
import kotlin.math.abs

class lol : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lol)
        ratings.rating=0.0f
        ratings.stepSize=.5f
        ratings.setOnRatingBarChangeListener { ratingBar, rating, fromUser ->
            Toast.makeText(this@lol, "Thanks", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@lol, "Ratings $ratings", Toast.LENGTH_SHORT).show()
        }
    }

}