package com.example.mylittlebackup

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Tela_de_questoes : AppCompatActivity() {
    private lateinit var textopergunta: TextView
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button

    private val perguntas_respostas = mapOf(
        "Qual forma geometrica possui 6 lados?" to listOf(
            Pair("hexagono", 10),
            Pair("pentagono", 0),
            Pair("Hectagono", 0),
            Pair("Sixagono", 0)
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_de_questoes)

        textopergunta = findViewById(R.id.questao)
        b1 = findViewById(R.id.resposta1)
        b2 = findViewById(R.id.resposta2)
        b3 = findViewById(R.id.resposta3)
        b4 = findViewById(R.id.resposta4)


        var perguntaAleatoria = perguntas_respostas.keys.random()

        textopergunta.text = perguntaAleatoria

        val respostas = perguntas_respostas[perguntaAleatoria]

        val respostasEmbaralhadas = respostas?.shuffled()

        b1.text = respostasEmbaralhadas?.get(0)?.component1()
        b2.text = respostasEmbaralhadas?.get(1)?.component1()
        b3.text = respostasEmbaralhadas?.get(2)?.component1()
        b4.text = respostasEmbaralhadas?.get(3)?.component1()

        b1.setOnClickListener {

            val respostaSelecionada = respostasEmbaralhadas?.get(0)?.component2()

            respostacorreta(respostaSelecionada!!.toInt())
        }

        b2.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas?.get(1)?.component2()

            respostacorreta(respostaSelecionada!!.toInt())
        }
        b3.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas?.get(2)?.component2()

            respostacorreta(respostaSelecionada!!.toInt())
        }
        b4.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas?.get(3)?.component2()

            respostacorreta(respostaSelecionada!!.toInt())
        }


    }

    fun respostacorreta(valor: Int) {
        if (valor == 10) {
            return Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show()

        } else {
            return Toast.makeText(this, "resposta errada :/", Toast.LENGTH_SHORT).show()
        }
    }


}