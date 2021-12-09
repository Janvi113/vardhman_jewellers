package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vardhmanjewellers.R
import adapter.favadapter
import Model.favmembers
import android.content.Intent
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_add_to_cart.*
import kotlinx.android.synthetic.main.activity_favorites.*
import kotlinx.android.synthetic.main.itemviewforcart.*

class favorites : AppCompatActivity() {
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        db= FirebaseFirestore.getInstance()
        button2.setOnClickListener {
            val intent= Intent(this,frontpage::class.java)
            startActivity(intent)
            finish()
        }


        favkarecyclerview.layoutManager=LinearLayoutManager(this)
        getdata()

    }

    private fun getdata() {

        db.collection("favcollection").get().addOnSuccessListener {

                documents ->


            for (document in documents) {
                val user = documents.toObjects(favmembers::class.java)
                favkarecyclerview.adapter = favadapter(this, user)


            }
        }

    }
}