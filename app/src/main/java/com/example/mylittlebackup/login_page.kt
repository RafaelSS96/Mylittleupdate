package com.example.mylittlebackup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class login_page : AppCompatActivity() {
    private lateinit var usernameEdit : EditText
    private lateinit var passwordEdit : EditText
    private lateinit var loginButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        usernameEdit= findViewById(R.id.usuariologin)
        passwordEdit=findViewById(R.id.senhalogin)
        loginButton=findViewById(R.id.botaologin)

        loginButton.setOnClickListener() {

            val username = usernameEdit.text.toString()
            val password = passwordEdit.text.toString()


            if (username == "admin" && password == "banana") {
                Toast.makeText(this, "Bem vindo adm, tela temporaria", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "você errou sua senha :/", Toast.LENGTH_SHORT).show()
            }
        }

        // aaaaa


    }
}