package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val firebaseAuth=FirebaseAuth.getInstance()
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        getSupportActionBar()?.hide()
        Handler(Looper.getMainLooper()).postDelayed({
            if(firebaseAuth.currentUser!=null){
                Toast.makeText(this, "user already logged in", Toast.LENGTH_SHORT).show()
                val intent=Intent(this,frontpage::class.java)
                startActivity(intent)
                finish()
            }
            else{
                val intent=Intent(this,intro::class.java)
                startActivity(intent)
                finish()
            }

        },3000)

       // val intent=Intent(this, intro::class.java)
       // intent.putExtra("name","9340469602")
         //startActivity(intent)
       // finish()


    }

    private fun redirect(name: String) {
        when(name){
       "LOGIN"->Intent(this,login::class.java)
            "MAIN"-> Intent(this,frontpage::class.java)
            else->throw Exception("no path exists")
        }
        startActivity(intent)
    }
}


