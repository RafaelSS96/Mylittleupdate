package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// tela de resultados, aqui algumas coisas precisarão ser esclarecidas, afinal é onde o codigo funcional
// e o codigo que não funcionou interagiam.

class Tela_resultado : AppCompatActivity() {


    // declaração das variaveis, a variavel bhistorico era pra ser um botão que mandaria para uma tela
    // que armazenaria o resultado do usuario, explicarei o que aconteceu a seguir.
    private lateinit var textoacertos: TextView
    private lateinit var btelaprincipal: Button
    private lateinit var porcacertos: TextView
   // private lateinit var bhistorico: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_resultado)

       // link entre as variaveis e o frontend

        textoacertos = findViewById(R.id.valoracertos)
        porcacertos = findViewById(R.id.porcentagemacertos)
        btelaprincipal = findViewById(R.id.botaoinicial)
       // bhistorico = findViewById(R.id.botaohistorico)


       // variaveis relacionadas a pagina bhistorico, esta aqui faz armazenamento do horario atual e
       // o exibe em um formato data, hora, minuto, segundo.

        val horaatual = LocalDateTime.now()
        val formatadordata = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
        val horafim = horaatual.format(formatadordata)

       // variaveis recebidas por intent da pagina de questões

        val acertos = intent.getIntExtra("pontos", 0)
        val nperguntas = intent.getIntExtra("quantiaperguntas", 1)


       // passagem do texto do numero de acertos para o elemento frontend
        textoacertos.text = acertos.toString() + " questões"

       // aqui é uma função interessante: Esta função calcula a porcentagem de acerto do usuario.
       // para evitar dizimas periodicas como 2/3 e seu 66,666...%, todas as variaveis passam por este
       // tratamento onde são reduzidas para apenas uma casa decimal de precisão.

        val decimalFormat = DecimalFormat("#.0")
        decimalFormat.maximumFractionDigits = 1
        val porAcertosAprox =
            decimalFormat.format((acertos.toDouble() / nperguntas.toDouble() * 100))

        porcacertos.text = porAcertosAprox.toString() + "%"

       // função do botão da tela principal, aqui o numero de perguntas da ultima atividade feita
       // é enviado de volta.

        btelaprincipal.setOnClickListener {
            val intent = Intent(this, Tela_principal::class.java)
            intent.putExtra("questoes", nperguntas)
            startActivity(intent)
            finish()
        }

       // por fim, o esqueleto do que era o botão bhistorico.
       // a pagina historico era para ser um recycledview que armazenaria os resultados desta sessão, porem,
       // o que aconteceu é que estes intents abaixos não chegavam a pagina.
       // este esqueleto ficará aqui para ser mudado em novas versões.

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