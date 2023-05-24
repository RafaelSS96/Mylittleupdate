package com.example.mylittlebackup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class config : AppCompatActivity() {

    private lateinit var salvar: Button
    private lateinit var texto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        texto = findViewById(R.id.nquestoes)
        salvar = findViewById(R.id.salvar)


        salvar.setOnClickListener {
            val numeroquestoes = texto.text.toString()
            if (numeroquestoes.toInt() in 1..10 && numeroquestoes.isNotEmpty()) {
                Toast.makeText(this, "Sua opção foi salva. Serão ${numeroquestoes} questões", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Tela_principal::class.java)
                intent.putExtra("numeroquestoes", numeroquestoes)
                startActivity(intent)
                finish()
            } else {
                val alertDialog = AlertDialog.Builder(this)
                    .setTitle("Você não informou uma opção valida. corrija ou a opção padrão será 3!")
                    .setPositiveButton("Corrigir") { dialog, which ->
                        null
                    }
                    .setNegativeButton("Não") { dialog, which ->
                        Toast.makeText(this, "Definido para 3 questões", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, Tela_principal::class.java)
                        intent.putExtra("numeroquestoes", 3)
                        startActivity(intent)
                        finish()
                    }
                alertDialog.show()
            }
        }
    }
}