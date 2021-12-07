import android.content.Context
import android.widget.Toast

fun Context.showtoast(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}