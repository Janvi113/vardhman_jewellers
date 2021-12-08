package activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vardhmanjewellers.R
import adapter.favadapter
import Model.favmembers
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_favorites.*

class favorites : AppCompatActivity() {
    lateinit var db:FirebaseFirestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)
        db= FirebaseFirestore.getInstance()
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