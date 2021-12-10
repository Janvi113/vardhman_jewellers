package activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import kotlinx.android.synthetic.main.activity_otpverification.*
import kotlinx.android.synthetic.main.activity_otpverification.view.*
import java.util.concurrent.TimeUnit
import com.example.vardhmanjewellers.R
import com.google.common.base.Verify
import com.google.firebase.auth.*


class otpverification : AppCompatActivity() {


    lateinit var firebaseAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()

        setContentView(R.layout.activity_otpverification)
        val storedVerificationId=intent.getStringExtra("storedVerificationId")
        numberentred.text="+91"+intent.getStringExtra("number")
        Login.setOnClickListener{
            var otp=otp_edit_box1.text.toString().trim()+otp_edit_box2.text.toString().trim()+otp_edit_box3.text.toString().trim()+otp_edit_box4.text.toString().trim()+otp_edit_box5.text.toString().trim()+otp_edit_box6.text.toString().trim()

            if(!otp.isEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(
                    storedVerificationId.toString(), otp)
                signInWithPhoneAuthCredential(credential)
            }else{
                Toast.makeText(this,"Enter OTP",Toast.LENGTH_SHORT).show()
            }
        }
        digitauto()
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        firebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(applicationContext, frontpage::class.java))
                    finish()
// ...
                } else {

                    if (task.exception is FirebaseAuthInvalidCredentialsException) {

                        Toast.makeText(this,"Invalid OTP",Toast.LENGTH_SHORT).show()
                    }
                }
            }
    }


    private fun digitauto() {
     otp_edit_box1.addTextChangedListener(object : TextWatcher {
         override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

         }

         override fun onTextChanged(p0: CharSequence? , p1: Int, p2: Int, p3: Int) {
             if(!p0.toString().isEmpty())
             {
                 otp_edit_box2.requestFocus()
             }

         }


         override fun afterTextChanged(p0: Editable?) {

         }

     })

        otp_edit_box2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence? , p1: Int, p2: Int, p3: Int) {
                if(!p0.toString().isEmpty())
                {
                    otp_edit_box3.requestFocus()
                }

            }


            override fun afterTextChanged(p0: Editable?) {

            }

        })

        otp_edit_box3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence? , p1: Int, p2: Int, p3: Int) {
                if(!p0.toString().isEmpty())
                {
                    otp_edit_box4.requestFocus()
                }

            }


            override fun afterTextChanged(p0: Editable?) {

            }

        })
        otp_edit_box4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence? , p1: Int, p2: Int, p3: Int) {
                if(!p0.toString().isEmpty())
                {
                    otp_edit_box5.requestFocus()
                }

            }


            override fun afterTextChanged(p0: Editable?) {

            }

        })
        otp_edit_box5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence? , p1: Int, p2: Int, p3: Int) {
                if(!p0.toString().isEmpty())
                {
                    otp_edit_box6.requestFocus()
                }

            }


            override fun afterTextChanged(p0: Editable?) {
               // val finalotp =
                 //   otp_edit_box1.text.toString() + otp_edit_box2.text.toString() + otp_edit_box3.text.toString() + otp_edit_box4.text.toString() + otp_edit_box5.text.toString() + otp_edit_box6.text.toString()


            }

        })




    }

}



