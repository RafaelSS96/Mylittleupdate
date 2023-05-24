package com.example.mylittlebackup

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Tela_de_questoes : AppCompatActivity() {
    private lateinit var textopergunta: TextView
    private lateinit var umdetres: TextView
    private lateinit var acertostela: TextView
    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var sair: Button
    private lateinit var respostasEmbaralhadas: List<Pair<String, Int>>

    private var contadorPerguntas = 0
    private var pontos = 0


    private val perguntas_respostas = mapOf(
        "Qual forma geometrica possui 6 lados?" to listOf(
            Pair("hexagono", 10),
            Pair("pentagono", 0),
            Pair("Hectagono", 0),
            Pair("Sixagono", 0)
        ),
        "Qual é a fórmula química da água?" to listOf(
            Pair("H2O", 10),
            Pair("CO2", 0),
            Pair("NaCl", 0),
            Pair("CH4", 0)
        ),
        "Qual foi o tratado que encerrou a Primeira Guerra Mundial? " to listOf(
            Pair("Tratado de Versalhes ", 10),
            Pair("Tratado de Tordesilhas", 0),
            Pair("Tratado de Varsóvia", 0),
            Pair("Tratado de Paris", 0)
        ),
        "Quais são os três estados de agregação da matéria" to listOf(
            Pair("Sólido, líquido e gasoso", 10),
            Pair("Sólido, líquido e plasma", 0),
            Pair("Líquido, gasoso e radioativo", 0),
            Pair("Sólido, gasoso e sublimado", 0)
        ),
        "Qual é o número de Avogadro?" to listOf(
            Pair("6,022 x 10^23", 10),
            Pair("5,352 x 10^23", 0),
            Pair("6 x 10^23", 0),
            Pair("6,22 x 10^23", 0)
        ),
        "Qual é o processo pelo qual uma substância passa diretamente do estado sólido para o gasoso?" to listOf(
            Pair("Sublimação", 10),
            Pair("Evaporação", 0),
            Pair("Fusão", 0),
            Pair("Condensação", 0),
        ),
        "Qual foi a primeira mulher a ganhar o Prêmio Nobel de Física?" to listOf(
            Pair("Marie Curie", 10),
            Pair("Rosalind Franklin", 0),
            Pair("Ada Lovelace", 0),
            Pair("Emmy Noether", 0),
        ),
        "Qual foi o primeiro país a enviar um ser humano ao espaço?" to listOf(
            Pair("União Soviética", 10),
            Pair("Estados Unidos", 0),
            Pair("China", 0),
            Pair("Alemanha", 0)
        ),
        "Qual é o maior oceano do mundo" to listOf(
            Pair("Oceano Pacífico", 10),
            Pair("Oceano Atlântico", 0),
            Pair("Oceano Índico", 0),
            Pair("Oceano Ártico", 0)
        ),

        "Qual foi a primeira capital do Brasil" to listOf(
            Pair("Salvador", 10),
            Pair("Brasília", 0),
            Pair("Rio de Janeiro", 0),
            Pair("São Paulo", 0),
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
        sair = findViewById(R.id.sair)
        umdetres = findViewById(R.id.umdetres)
        acertostela = findViewById(R.id.acertos)


        val numeroperguntas = intent.getIntExtra("numeroquestoes", 3)


        gerarpergunta()

        sair.setOnClickListener {
            finish()
        }

        b1.setOnClickListener {

            val respostaSelecionada = respostasEmbaralhadas.get(0).component2()

            respostacorreta(respostaSelecionada, numeroperguntas)
        }

        b2.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas.get(1).component2()

            respostacorreta(respostaSelecionada, numeroperguntas)
        }
        b3.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas.get(2).component2()

            respostacorreta(respostaSelecionada, numeroperguntas)
        }
        b4.setOnClickListener {
            val respostaSelecionada = respostasEmbaralhadas.get(3).component2()

            respostacorreta(respostaSelecionada, numeroperguntas)
        }

        acertostela.text = pontos.toString()

        umdetres.text = "Pergunta ${contadorPerguntas + 1} de $numeroperguntas"
    }

    private fun respostacorreta(valor: Int, quantiaperguntas: Int) {
        if (valor == 10) {
            Toast.makeText(this, "Resposta correta!", Toast.LENGTH_SHORT).show()
            pontos++
            acertostela.text = pontos.toString()
            contadorPerguntas++
            if (contadorPerguntas < quantiaperguntas) {
                umdetres.text = "Pergunta ${contadorPerguntas + 1} de $quantiaperguntas"
                gerarpergunta()
                return
            }

        } else {
            Toast.makeText(this, "resposta errada :/", Toast.LENGTH_SHORT).show()
            contadorPerguntas++
            if (contadorPerguntas < quantiaperguntas) {
                umdetres.text = "Pergunta ${contadorPerguntas + 1} de $quantiaperguntas"
                gerarpergunta()
                return
            }
        }
    }

    private fun gerarpergunta() {
        val perguntaAleatoria = perguntas_respostas.keys.random()

        textopergunta.text = perguntaAleatoria

        val respostas = perguntas_respostas[perguntaAleatoria]

        respostasEmbaralhadas = respostas?.shuffled() ?: emptyList()

        b1.text = respostasEmbaralhadas.get(0).component1()
        b2.text = respostasEmbaralhadas.get(1).component1()
        b3.text = respostasEmbaralhadas.get(2).component1()
        b4.text = respostasEmbaralhadas.get(3).component1()
    }


}