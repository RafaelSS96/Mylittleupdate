package com.example.mylittlebackup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var bmain : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bmain= findViewById(R.id.buttonmain)

        bmain.setOnClickListener {
            val intent = Intent (this, login_page::class.java)
            startActivity(intent)
        }
    }


}