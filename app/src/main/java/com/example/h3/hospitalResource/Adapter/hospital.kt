package com.example.h3.hospitalResource.Adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.h3.R
import com.example.h3.UpHospital
import com.example.h3.hospital_resource
import kotlinx.android.synthetic.main.activity_hospital.*

class hospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital)

        UttarPradesh.setOnClickListener {
            val i= Intent(this,UpHospital::class.java)
            startActivity(i)
        }
        Bengaluru.setOnClickListener {
            val i= Intent(this,hospital_resource::class.java)
            startActivity(i)
        }

    }
}