package com.example.mylittlebackup

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


// tela inicial do codigo. Decidi transformar ela de um botão em um runnable por questão visual alem que como a
//app ficou bem mais interna no celular, pareceu uma ideia melhor.
class MainActivity : AppCompatActivity() {


    // declaração da variavel de time out, depois de 3 segundos ela executa uma x ação.
    private val time_out = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // criação de um handler, apesar de descontinuado em java, ainda muito util no kotlin

        val handler = Handler()


        // criação de um runnable com a ação que executará, no caso, ele fara a chamada da pagina Tela_principal
        // e terminará a atividade atual.

        val runnable = Runnable {

            val intent = Intent(this, Tela_principal::class.java)
            startActivity(intent)
            finish()
        }


        // aqui é onde a magia deste codigo realmente acontece. Este handle executa a ação definida no runnable
        //após um certo tempo se passar, no caso, 3 segundos.

        handler.postDelayed(runnable, time_out.toLong())
    }


}