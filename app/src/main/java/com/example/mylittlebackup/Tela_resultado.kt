package com.example.mylittlebackup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class Tela_resultado : AppCompatActivity() {

    private lateinit var textoacertos: TextView
    private lateinit var btelaprincipal: Button
    private lateinit var bhistorico: Button
    private lateinit var porcacertos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        textoacertos = findViewById(R.id.valoracertos)
        porcacertos = findViewById(R.id.porcentagemacertos)
        btelaprincipal = findViewById(R.id.botaoinicial)
        bhistorico = findViewById(R.id.botaohistorico)

        val acertos = intent.getIntExtra("pontos", 0)
        val nperguntas = intent.getIntExtra("quantiaperguntas", 1)

        textoacertos.text = acertos.toString()+" questões"

        val decimalFormat= DecimalFormat("#.0")
        decimalFormat.maximumFractionDigits = 1
        val porAcertosAprox = decimalFormat.format((acertos.toDouble() / nperguntas.toDouble() * 100))

        porcacertos.text = porAcertosAprox.toString()+"%"


    }
}