package com.example.a19_09_2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.dashboard.*



class Dashboard : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard)
        btniniciar.setOnClickListener {cadastrarcliente() }
        cadastrarvaiculo.setOnClickListener {cadastrarvaiculo() }

        val params = intent.extras
        val nome = params?.getString("nome_usuario")
        val n = params?.getString("numero")

        //Toast.makeText(this, "Bem vindo $nome", Toast.LENGTH_LONG).show()
        supportActionBar?.title = "Dashboard"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }


    fun cadastrarvaiculo(){


        var intent = Intent(this, CadastrarVeiculo::class.java)
        var params = Bundle ()
        params.putString("nome_usuario", "nome")
        params.putInt("numero", 10)
        params.putIntArray("array_int", intArrayOf(1,2,3))
        intent.putExtras(params)
        startActivity(intent)
    }
    fun cadastrarcliente(){
        var intent = Intent(this, CadastrarCliente::class.java)
        var params = Bundle ()
        params.putString("nome_usuario", "nome")
        params.putInt("numero", 10)
        params.putIntArray("array_int", intArrayOf(1,2,3))
        intent.putExtras(params)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id= item?.itemId

        if (id == R.id.action_buscar){
            Toast.makeText(this, "clicou em buscar",
                Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_atualizar){
            Toast.makeText(this, "clicou em atualizar",
                Toast.LENGTH_SHORT).show()


        }else if (id == android.R.id.home)
            finish()


        return super.onOptionsItemSelected(item)
    }
}