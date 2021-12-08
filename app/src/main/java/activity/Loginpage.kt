package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class loginpage : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)
        val no1 = intent.getStringExtra("no1")
        val no2 = intent.getStringExtra("no2")
        val no3 = intent.getStringExtra("no3")
        val no4 = intent.getStringExtra("no4")
        val no5 = intent.getStringExtra("no5")
        val no6 = intent.getStringExtra("no6")
        val otpid = intent.getStringExtra("otpkaid")
        val finalotp =
            no1.toString() + no2.toString() + no3.toString() + no4.toString() + no5.toString() + no6.toString()
        val credential: PhoneAuthCredential = PhoneAuthProvider.getCredential(otpid.toString(), finalotp)

signInWithPhoneAuthCredential(credential)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "succes registred", Toast.LENGTH_SHORT).show()
                } else {
                    // Sign in failed, display a message and update the UI
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        Toast.makeText(this, "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }

            }
    }
}


