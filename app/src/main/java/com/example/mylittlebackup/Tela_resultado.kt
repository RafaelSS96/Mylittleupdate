package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Tela_resultado : AppCompatActivity() {

    private lateinit var textoacertos: TextView
    private lateinit var btelaprincipal: Button
   // private lateinit var bhistorico: Button
    private lateinit var porcacertos: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

        textoacertos = findViewById(R.id.valoracertos)
        porcacertos = findViewById(R.id.porcentagemacertos)
        btelaprincipal = findViewById(R.id.botaoinicial)
       // bhistorico = findViewById(R.id.botaohistorico)

        val horaatual = LocalDateTime.now()
        val formatadordata = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        val horafim = horaatual.format(formatadordata)

        val acertos = intent.getIntExtra("pontos", 0)
        val nperguntas = intent.getIntExtra("quantiaperguntas", 1)

        textoacertos.text = acertos.toString() + " questões"

        val decimalFormat = DecimalFormat("#.0")
        decimalFormat.maximumFractionDigits = 1
        val porAcertosAprox =
            decimalFormat.format((acertos.toDouble() / nperguntas.toDouble() * 100))

        porcacertos.text = porAcertosAprox.toString() + "%"

        btelaprincipal.setOnClickListener {
            val intent = Intent(this, Tela_principal::class.java)
            intent.putExtra("questoes", nperguntas)
            startActivity(intent)
            finish()
        }

        /*  bhistorico.setOnClickListener {
              val intent = Intent(this, Tela_historico::class.java)
              intent.putExtra("acertos", acertos)
              intent.putExtra("questoes", nperguntas)
              intent.putExtra("pacertos", porAcertosAprox)
              intent.putExtra("horaFim", horafim)
              startActivity(intent)
              finish()
          }*/
    }
}