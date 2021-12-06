package com.example.vardhmanjewellers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_recyclerview.*

class recyclerview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var i=1
        setContentView(R.layout.activity_recyclerview)
        add.setOnClickListener(){
            i=i+1
            amount.text="$i"
        }
        subtract.setOnClickListener(){
            if(i>=2)
            {
                i=i-1
                amount.text="$i"
            }
        }

    }
}