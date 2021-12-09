package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class login : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()


        button3.setOnClickListener {

            val email = editTextTextEmailAddress.editableText.toString().trim()
            val password = editTextTextPassword.editableText.toString().trim()
            if (email.isBlank()||password.isBlank()){
                Toast.makeText(this, "empty", Toast.LENGTH_SHORT).show()
            }
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "sucessfully login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,frontpage::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, "unsucessfully login", Toast.LENGTH_SHORT).show()
                }
            }


        }



    }
    }
