package com.example.mylittlebackup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Tela_historico : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_historico)

        val intentextras = intent.extras
        if(intentextras != null) {
            val acertos = intentextras.getInt("acertos")
            val questoes = intentextras.getInt("questoes")
            val pacertos = intentextras.getString("pacertos")
            val horaFim = intentextras.getString("horaFim")
        } else {
            val acertos = 0
            val questoes = 0
            val pacertos = "0"
            val horaFim = "N/A"
        }


    }
}