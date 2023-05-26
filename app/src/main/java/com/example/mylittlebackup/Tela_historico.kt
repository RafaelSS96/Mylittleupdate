package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// tela de historico, apesar de não usada, posso explicar tudo que aconteceu.
class Tela_historico : AppCompatActivity() {

    // declaração das variaveis

    private lateinit var reciclar : RecyclerView
    private lateinit var btelainicial : Button
    val historicoList = mutableListOf<HistoricoItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_historico)

        btelainicial = findViewById(R.id.historico_telaprincipal)

        // declaração das variaveis, aqui era onde o problema acontecia.

        var acertos = 0
        var questoes = 0
        var pacertos = "0"
        var horaFim = "N/A"

        // tentativa de pegar o material do intent

        val intentextras = intent.extras
        if (intentextras != null) {
            var acertos = intentextras.getInt("acertos")
            var questoes = intentextras.getInt("questoes")
            var pacertos = intentextras.getString("pacertos")
            var horaFim = intentextras.getString("horaFim")
        }

        //funções que adicionariam os itens separados na pagina de respostas para o recycledview

        historicoList.add(HistoricoItem(horaFim, acertos, questoes, pacertos))

        //criação do recycledview em si junto da sua declaração.
        reciclar = findViewById(R.id.recyclerhistorico)
        val layoutManager = LinearLayoutManager(this)
        reciclar.layoutManager = layoutManager

        // uma classe de data para poder alojar melhor as funções.
        val historicoAdapter = HistoricoAdapter(historicoList)
        reciclar.adapter = historicoAdapter


        // uma função de um botão que levaria pra tela inicial
        btelainicial.setOnClickListener{
            val intent = Intent(this, Tela_principal::class.java)
            intent.putExtra("questoes", questoes)
            startActivity(intent)
        }
    }

    data class HistoricoItem(
        val data: String,
        val acertos: Int,
        val questoes: Int,
        val pacertos: String
    )

    // declarações do recycled view aqui, seria passada cada um dos itens para um respectivo item no
    // adaptador e por fim, o recycledview e o seu adapter seriam inflados na tela.

    class HistoricoAdapter(private val dataSet: List<HistoricoItem>) :
        RecyclerView.Adapter<HistoricoAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val numeroquestoes: TextView = view.findViewById(R.id.numeroquestoes)
            val numeroacertos: TextView = view.findViewById(R.id.numeroacertos)
            val pacertoshistorico: TextView = view.findViewById(R.id.pacertoshistorico)
            val datahorahistorico: TextView = view.findViewById(R.id.datahorahistorico)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
            return ViewHolder(view)
        }


        // funções de passagem dos itens da data para o recycled view propriamente
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = dataSet[position]
            holder.datahorahistorico.text = item.data
            holder.numeroacertos.text = item.acertos.toString()
            holder.numeroquestoes.text = item.questoes.toString()
            holder.pacertoshistorico.text = item.pacertos
        }

        // definição do tamanho da lista do recycled view.

        override fun getItemCount(): Int {
            return dataSet.size
        }
    }
}