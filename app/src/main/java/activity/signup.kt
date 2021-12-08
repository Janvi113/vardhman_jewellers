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
    private  lateinit var editTextTextEmailAddress2: EditText
    private  lateinit var editTextTextPassword2: EditText
    private  lateinit var editTextTextPassword3: EditText
    private lateinit var registerid: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        editTextTextEmailAddress2=findViewById(R.id.editTextTextEmailAddress2)
        editTextTextPassword2=findViewById(R.id.editTextTextPassword2)
        editTextTextPassword3=findViewById(R.id.editTextTextPassword3)
        registerid=findViewById(R.id.registerid)
        firebaseAuth= FirebaseAuth.getInstance()
        image_signup.setOnClickListener {
            val intent= Intent(this,login::class.java)
            startActivity(intent)
            finish()
        }
        registerid.setOnClickListener {

            val email=editTextTextEmailAddress2.text.toString().trim()
            val password=editTextTextPassword2.text.toString().trim()
            val confirmpassword=editTextTextPassword3.text.toString().trim()
            if(email.isEmpty()){
                editTextTextEmailAddress2.error="email is required"
                return@setOnClickListener

            }
            else if(password.isEmpty()){
                editTextTextPassword2.error="Password is required"
                return@setOnClickListener

            }

            else if(password!=confirmpassword){
                editTextTextPassword3.error="password should be matched"
                return@setOnClickListener
            }
            else if(editTextTextPassword.length()>6){
                editTextTextPassword.error = "Password should be greater than 6 character"
                return@setOnClickListener
            }
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
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