package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var editTextTextEmailAddress: EditText
    private lateinit var editTextTextPassword: EditText
    private lateinit var button3: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextTextEmailAddress=findViewById(R.id.editTextTextEmailAddress)
        editTextTextPassword=findViewById(R.id.editTextTextPassword)
        button3=findViewById(R.id.button3)
        firebaseAuth = FirebaseAuth.getInstance()


        button3.setOnClickListener {

            val email = editTextTextEmailAddress.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()
            if (email.isEmpty()) {
                editTextTextEmailAddress.error = "email is required"
                return@setOnClickListener

            } else if (password.isEmpty()) {
                editTextTextPassword.error = "Password is required"
                return@setOnClickListener

            }
            else if(editTextTextPassword.length()>6){
                editTextTextPassword.error = "Password should be greater than 6 character"
                return@setOnClickListener
            }
            firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful){
                    Toast.makeText(this, "sucessfully login", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                }
                else{
                    Toast.makeText(this, "unsucessfully login", Toast.LENGTH_SHORT).show()
                }
            }


        }



    }
    }
