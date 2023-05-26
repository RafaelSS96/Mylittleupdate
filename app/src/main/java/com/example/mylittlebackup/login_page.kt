package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//login page que não é mais usada no codigo, uma preve explicação do que ela devia fazer a seguir:
class login_page : AppCompatActivity() {


    //declaração das variaveis usadas aqui, 2 edit texts para usuario e senha e um botão para
    //realizar o login
    private lateinit var usernameEdit: EditText
    private lateinit var passwordEdit: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        //link entre as variaveis e seus respectivos elementos no layout

        usernameEdit = findViewById(R.id.usuariologin)
        passwordEdit = findViewById(R.id.senhalogin)
        loginButton = findViewById(R.id.botaologin)


        // função do botão declarado acima

        loginButton.setOnClickListener() {


            // criação de duas variaveis que alojam o texto do edittexts acima.

            val username = usernameEdit.text.toString()
            val password = passwordEdit.text.toString()


            // aqui foi um if else bem simples para fazer um sistema de login local.
            // comparação boba: Se o usuario ou a senha forem diferentes do que foi determinado aqui, a app
            // não permitiria o acesso a proxima pagina.

            if (username == "admin" && password == "banana") {
                Toast.makeText(this, "Bem vindo adm, tela temporaria", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Tela_principal::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "você errou sua senha :/", Toast.LENGTH_SHORT).show()
            }
        }


    }
}