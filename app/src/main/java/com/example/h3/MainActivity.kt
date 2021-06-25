package com.example.h3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.h3.tracker.covidmain_activity
import com.example.h3.vaccin.vaccination
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hospital.setOnClickListener {

            val i= Intent(this,hospital_resource::class.java)
            startActivity(i)


        }

        vaccin.setOnClickListener {

            val i= Intent(this, vaccination::class.java)
            startActivity(i)

        }

        Tracker.setOnClickListener {

            val i= Intent(this, covidmain_activity::class.java)
            startActivity(i)

        }



    }
}