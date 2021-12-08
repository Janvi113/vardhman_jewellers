package activity

import android.app.Dialog
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.vardhmanjewellers.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {
    lateinit var firestore: FirebaseFirestore
    lateinit var auth: FirebaseAuth
    lateinit var firebase: DatabaseReference
    lateinit var binding: ActivityProfileBinding
    lateinit var storageReference: StorageReference
    lateinit var imageuri:Uri
    lateinit var dialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
         firestore= FirebaseFirestore.getInstance()
         auth= FirebaseAuth.getInstance()

                binding.savebtn.setOnClickListener {
                    val name= binding.fullNameProfile.editText?.text.toString()
                    val email=binding.fullNameEmail.editText?.text.toString()
                    val phoneno=binding.fullNameEmail.editText?.text.toString()
                    val password=binding.fullNameEmail.editText?.text.toString()
                    savestore(name, email, phoneno, password)
                    profilepic()
                }


    }

    private fun profilepic() {
        firestore.collection("Users").get().addOnCompleteListener {

                if (it.isSuccessful) {
                    val result: StringBuffer = StringBuffer()

                    for (document in it.result!!) {
                        result.append(document.data.get("name")).append("\n\n")
                    }
                    yours.setText(result)


                }

        }



    }
    private fun savestore(name: String, email: String, phoneno: String, password: String) {

        val users: MutableMap<String,Any> =HashMap()
        users["name"]=name

        firestore.collection("Users").add(users).addOnSuccessListener {
            Toast.makeText(this, "sucessfull", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "unsucessful", Toast.LENGTH_SHORT).show()
        }


    }
 
}

    


    



