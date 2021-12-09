package Model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide.init
import com.example.vardhmanjewellers.R
import com.makeramen.roundedimageview.RoundedImageView

class sliderAdapter internal constructor(Slideritems: MutableList<slideritems>,
      viewpager: ViewPager2): RecyclerView.Adapter<sliderAdapter.sliderholder>() {

     private val Slideritems: List<slideritems>
     private val viewpager: ViewPager2
      init {
          this.Slideritems=Slideritems
        this.viewpager=viewpager
      }

    inner class sliderholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
              private val imageView:RoundedImageView=itemView.findViewById(R.id.imageslider)

              fun image(Slideritem: slideritems){
                  imageView.setImageResource(Slideritem.image)
              }
          }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): sliderholder {
        val inflator=LayoutInflater.from(parent.context)
        val view=inflator.inflate(R.layout.dialog_bar,parent,false)
        return sliderholder(view)
    }

    override fun onBindViewHolder(holder: sliderholder, position: Int) {
    holder.image(Slideritems[position])
       if (position==Slideritems.size-2){
        viewpager.post(runnable)
       }
    }

    override fun getItemCount(): Int {
        return Slideritems.size
    }
   private val runnable= Runnable {
       Slideritems.addAll(Slideritems)
       notifyDataSetChanged()
    }
}