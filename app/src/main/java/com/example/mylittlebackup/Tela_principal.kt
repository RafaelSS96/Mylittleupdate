package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Tela_principal : AppCompatActivity() {

    private lateinit var novaatividade: Button
    private lateinit var numeroatividades: TextView
    private lateinit var tatividades: TextView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        novaatividade = findViewById(R.id.novaatividade)
        numeroatividades = findViewById(R.id.numeroatividades)
        tatividades = findViewById(R.id.totalatividades)


        var numeroQuestoes = intent.getStringExtra("numeroquestoes")
        if (numeroQuestoes == null) {
            numeroQuestoes = "3"
        }

        var totalquestões = intent.getIntExtra("questoes", 0)
        tatividades.text = totalquestões.toString()

        numeroatividades.text = numeroQuestoes

        toolbar = findViewById(R.id.toolbarMenuPrincipal)
        setSupportActionBar(toolbar)

        novaatividade.setOnClickListener {
            val intent = Intent(this, Tela_de_questoes::class.java)
            intent.putExtra("numeroquestoes", numeroQuestoes.toInt())
            startActivity(intent)
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_pagina_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.configuracao -> {
                val intent = Intent(this, config::class.java)
                startActivity(intent)
            }

            R.id.deslogar -> {
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
