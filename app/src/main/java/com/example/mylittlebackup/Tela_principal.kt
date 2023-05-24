package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class Tela_principal : AppCompatActivity() {

    private lateinit var novaatividade: Button
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        novaatividade = findViewById(R.id.novaatividade)

        novaatividade.setOnClickListener {
            val intent = Intent(this, Tela_de_questoes::class.java)
            startActivity(intent)
        }

        toolbar = findViewById(R.id.toolbarMenuPrincipal)
        setSupportActionBar(toolbar)
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