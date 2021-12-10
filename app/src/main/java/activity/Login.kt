package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.google.common.base.Verify
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.TimeUnit

class login : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var storedVerificationId:String
    lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        firebaseAuth = FirebaseAuth.getInstance()


        button3.setOnClickListener {

            val email = editTextTextEmailAddress.editableText.toString().trim()
            val password = editTextTextPassword.editableText.toString().trim()
            val phonenumber = edittextphonenumber.editableText.toString().trim()
            if (email.isBlank() && password.isBlank()) {
                if (phonenumber.isBlank()) {

                    Toast.makeText(
                        this,
                        "enter phone number or mail id and pass",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(this, "+91$phonenumber", Toast.LENGTH_SHORT).show()
                    sendVerificationcode("+91$phonenumber")
                }


            }

            if (phonenumber.isBlank()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "sucessfully login", Toast.LENGTH_SHORT).show()
                        //  sendVerificationcode ("+919340469602")
                        val intent = Intent(this, frontpage::class.java)
                        startActivity(intent)
                        finish()

                    } else {
                        Toast.makeText(this, "unsucessfully login", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }









            callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                override fun onVerificationCompleted(credential: PhoneAuthCredential) {

                }

                override fun onVerificationFailed(e: FirebaseException) {
                    Toast.makeText(applicationContext, "Failed", Toast.LENGTH_LONG).show()
                }

                override fun onCodeSent(
                    verificationId: String,
                    token: PhoneAuthProvider.ForceResendingToken
                ) {

                    Log.d("TAG", "onCodeSent:$verificationId")
                    storedVerificationId = verificationId
                    resendToken = token
                    var intent = Intent(applicationContext, otpverification::class.java)
                    intent.putExtra("storedVerificationId", storedVerificationId)
                    intent.putExtra("number",(edittextphonenumber.editableText.toString().trim()))
                    startActivity(intent)
                }
            }

        }


    private fun sendVerificationcode(number: String) {
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber(number) // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this) // Activity (for callback binding)
            .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }
}
