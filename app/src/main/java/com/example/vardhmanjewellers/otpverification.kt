package com.example.vardhmanjewellers

import android.R.attr
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.android.synthetic.main.activity_otpverification.*
import kotlinx.android.synthetic.main.activity_otpverification.view.*
import java.util.concurrent.TimeUnit
import android.R.attr.phoneNumber
import android.R.attr.toAlpha
import android.content.Intent


class otpverification : AppCompatActivity() {
var otpidd="no"

    lateinit var firebaseAuth: FirebaseAuth
    private lateinit var mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        firebaseAuth = FirebaseAuth.getInstance()

        setContentView(R.layout.activity_otpverification)
        otpsend()
        digitauto()
      /*  button2.setOnClickListener()
        {
          val intent=Intent(this,loginpage::class.java)
            intent.putExtra("no1",otp_edit_box1.text.toString())
            intent.putExtra("no2",otp_edit_box2.text.toString())
            intent.putExtra("no3",otp_edit_box3.text.toString())
            intent.putExtra("no4",otp_edit_box4.text.toString())
            intent.putExtra("no5",otp_edit_box5.text.toString())
            intent.putExtra("no6",otp_edit_box6.text.toString())
            intent.putExtra("otpkaid",otpidd)
            startActivity(intent)
        }*/








        //numberentred.text = "+919340469602"


    }



private  fun verificatoncallbacks(){
    mCallbacks= object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
        override fun onVerificationCompleted(p0: PhoneAuthCredential) {
            Toast.makeText(this@otpverification, "succesful", Toast.LENGTH_SHORT).show()

        }

        override fun onVerificationFailed(p0: FirebaseException) {
            Toast.makeText(this@otpverification, "failed", Toast.LENGTH_SHORT).show()

        }

        override fun onCodeSent(otpid:String , p1: PhoneAuthProvider.ForceResendingToken) {
            Toast.makeText(this@otpverification, "sended", Toast.LENGTH_SHORT).show()
            otpidd= otpid





        }

    }
}
    private fun otpsend() {

        verificatoncallbacks()
        val options = PhoneAuthOptions.newBuilder(firebaseAuth)
            .setPhoneNumber("+919340469602")       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        verificatoncallbacks()

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



