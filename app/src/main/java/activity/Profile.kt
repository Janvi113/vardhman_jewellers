package activity

import android.app.Dialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.vardhmanjewellers.R
import com.example.vardhmanjewellers.databinding.ActivityProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_profile.*

class profile : AppCompatActivity() {
    lateinit var firestore: FirebaseFirestore
    lateinit var auth: FirebaseAuth
    lateinit var firebase: DatabaseReference
    lateinit var binding: ActivityProfileBinding
    lateinit var button: Button
    lateinit var imageView: CircleImageView

    companion object{
        val IMAGE_REQUEST_CODE=100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   binding= ActivityProfileBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_profile)
         firestore= FirebaseFirestore.getInstance()
         auth= FirebaseAuth.getInstance()
         button=findViewById(R.id.savebtn)
        imageView=findViewById(R.id.imaepicid)
              button.setOnClickListener {
                    profilepic()
                }


    }

    private fun profilepic() {
        val intent= Intent(Intent.ACTION_PICK)
        intent.type="Image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)

        }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode== IMAGE_REQUEST_CODE&&resultCode== RESULT_OK)
        {
            imageView.setImageURI(data?.data)
        }
    }



 
}

    


    



