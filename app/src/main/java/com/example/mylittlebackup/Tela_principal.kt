package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//tela principal, o centro nervoso desta app:
class Tela_principal : AppCompatActivity() {

    // declaração das variaveis usadas dentro do sistema como um todo

    private lateinit var novaatividade: Button
    private lateinit var numeroatividades: TextView
    private lateinit var tatividades: TextView
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_principal)

        //atribuição das variaveis a seus respectivos elementos

        novaatividade = findViewById(R.id.novaatividade)
        numeroatividades = findViewById(R.id.numeroatividades)
        tatividades = findViewById(R.id.totalatividades)
        toolbar = findViewById(R.id.toolbarMenuPrincipal)


        // aqui a criação do do elemento que recebe o numero de questões do usuario.
        // este é um numero que vem da pagina config, porem caso não seja configurado é setado como
        // 3.

        var numeroQuestoes = intent.getStringExtra("numeroquestoes")
        if (numeroQuestoes == null) {
            numeroQuestoes = "3"
        }

        // declaração do valor de totalquestoes, funciona de uma forma parecida como o anterior, porem,
        // como este foi declarado como int, consigo criar um default value na sua criação.

        val totalquestoes = intent.getIntExtra("questoes", 0)

        // passagens do valor para o elemento de layout para ser exibido ao usuario.
        tatividades.text = totalquestoes.toString()
        numeroatividades.text = numeroQuestoes

        // aqui nossa toolbar é definida como uma "action bar". Isto é necessario para que para que ela
        // seja personalizada como queremos, com botões proprios como ja foi visto no botão config
        setSupportActionBar(toolbar)


        // definição da função de nova atividade. Afim de evitar as trapaças, caso um usuario deseje voltar
        // e não aperte a opção sair na tela de atividades, esta função finish o "expulsa" da app.
        novaatividade.setOnClickListener {
            val intent = Intent(this, Tela_de_questoes::class.java)
            intent.putExtra("numeroquestoes", numeroQuestoes.toInt())
            startActivity(intent)
            finish()
        }
    }


    // inflater para fazer a criação em si das funções da toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_pagina_principal, menu)
        return true
    }


    // função que define o que cada botão faz, como exibido abaixo.
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.configuracao -> {
                val intent = Intent(this, config::class.java)
                startActivity(intent)
            }

            R.id.deslogar -> {
                finish()
            }
        }

        // execução da função super aqui para garantir que a função do click do botão seja devidamente
        // associada antes do botão em si ser personalizado em outras formas.
        return super.onOptionsItemSelected(item)
    }


}
