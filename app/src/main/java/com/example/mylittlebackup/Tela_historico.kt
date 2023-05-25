package com.example.mylittlebackup

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tela_historico : AppCompatActivity() {

    private lateinit var reciclar : RecyclerView
    val historicoList = mutableListOf<HistoricoItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_historico)

        val acertos = 0
        val questoes = 0
        val pacertos = "0"
        val horaFim = "N/A"

        val intentextras = intent.extras
        if (intentextras != null) {
            val acertos = intentextras.getInt("acertos")
            val questoes = intentextras.getInt("questoes")
            val pacertos = intentextras.getString("pacertos")
            val horaFim = intentextras.getString("horaFim")
        }

        historicoList.add(HistoricoItem(horaFim, acertos, questoes, pacertos))
        reciclar = findViewById(R.id.recyclerhistorico)
        val layoutManager = LinearLayoutManager(this)
        reciclar.layoutManager = layoutManager

        val historicoAdapter = HistoricoAdapter(historicoList)
        reciclar.adapter = historicoAdapter
    }

    data class HistoricoItem(
        val data: String,
        val acertos: Int,
        val questoes: Int,
        val pacertos: String
    )

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

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val item = dataSet[position]
            holder.datahorahistorico.text = item.data
            holder.numeroacertos.text = item.acertos.toString()
            holder.numeroquestoes.text = item.questoes.toString()
            holder.pacertoshistorico.text = item.pacertos
        }

        override fun getItemCount(): Int {
            return dataSet.size
        }
    }
}