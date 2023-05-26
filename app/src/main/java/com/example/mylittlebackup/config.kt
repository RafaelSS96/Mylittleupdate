package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

// função config da tela principal, bem simplezinha.

class config : AppCompatActivity() {

    // declaração do valor das variaveis

    private lateinit var salvar: Button
    private lateinit var texto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_config)

        //definição de seus respectivos pares

        texto = findViewById(R.id.nquestoes)
        salvar = findViewById(R.id.salvar)


        // função salvar, que passa de volta o numero de questões do usuario.

        salvar.setOnClickListener {
            val numeroquestoes = texto.text.toString()

            // if else bem simples para salvar as opções do usuario.
            if (numeroquestoes.toInt() in 1..10 && numeroquestoes.isNotEmpty()) {

                // um toast para ficar claro pro usuario o que aconteceu, um intent para mover para a tela
                // principal, um intent.putextra para enviar a informação e um finish para "matar" a atividade
                // da config.


                Toast.makeText(
                    this,
                    "Sua opção foi salva. Serão ${numeroquestoes} questões",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this, Tela_principal::class.java)
                intent.putExtra("numeroquestoes", numeroquestoes)
                startActivity(intent)
                finish()
            } else {

                // esse else é nossa opção caso o usuario responda um valor indevido. A opção gera um alert
                // dialog que "pula" na tela do usuario e o avisa do que aconteceu.
                // caso ele deseje corrigir, nada acontece, caso contrario, o valor vai setado como 3.


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