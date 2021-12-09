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
import kotlinx.android.synthetic.main.activity_signup.*

class signup : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        firebaseAuth= FirebaseAuth.getInstance()
        image_signup.setOnClickListener {
            val intent= Intent(this,login::class.java)
            startActivity(intent)
            finish()
        }
        registerid.setOnClickListener {

            val email=editTextTextEmailAddress2.editableText.toString().trim()
            val password=editTextTextPassword2.editableText.toString().trim()
            val confirmpassword=editTextTextPassword3.editableText.toString().trim()
            if(email.isBlank()||password.isBlank()||confirmpassword.isBlank()){
                Toast.makeText(this, "should not be empty", Toast.LENGTH_SHORT).show()
            }
            if (password!=confirmpassword){
                Toast.makeText(this, "password", Toast.LENGTH_SHORT).show()
            }
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this, "sucessfully signup", Toast.LENGTH_SHORT).show()
                    val intent=Intent(this,login::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "unsucessfully signup", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}