package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vardhmanjewellers.R
import kotlinx.android.synthetic.main.activity_intro.*

class intro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        btn.setOnClickListener {
            val intent= Intent(this, login::class.java)
            startActivity(intent)

        }
        btn1.setOnClickListener {
            val intent= Intent(this, signup::class.java)
            startActivity(intent)
        }
    }
}