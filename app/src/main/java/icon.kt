import com.example.vardhmanjewellers.R

object icon {
    val topimages= arrayOf(R.drawable.mangtikka,R.drawable.omring,R.drawable.flora,R.drawable.geometricring)
    val iconpicken= arrayOf(R.drawable.anklet,
        R.drawable.ring,R.drawable.neclace, R.drawable.earing,R.drawable.bangles)
    var currenticon=0
    fun iconic(): Int{
        currenticon=(currenticon+1)% iconpicken.size
        return iconpicken[currenticon]
    }
    fun topbrandsicon():Int{
        currenticon=(currenticon+1)% topimages.size
        return topimages[currenticon]
    }
}