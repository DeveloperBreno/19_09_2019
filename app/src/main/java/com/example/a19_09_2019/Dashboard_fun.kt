package com.example.a19_09_2019

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.dashboard_fun.*

class Dashboard_fun : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dashboard_fun)
        btn_cliente.setOnClickListener { btn_Cliente() }
        btn_veiculo.setOnClickListener { btn_Veiculo() }
        btn_list_clientes.setOnClickListener{ listar_clientes() }
        btn_list_veiculos.setOnClickListener{ listar_veiculos() }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sair, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id= item?.itemId

        if (id == R.id.action_sair){
            btn_Sair()
        }
        return super.onOptionsItemSelected(item)
    }

    fun btn_Sair(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        this.finish()

    }

    fun listar_veiculos(){
        var intent = Intent(this, ListarVeiculos ::class.java)
        startActivity(intent)
    }
    fun listar_clientes(){
        var intent = Intent(this, ListarClientes::class.java)
        startActivity(intent)
    }



    fun btn_Cliente(){
        var intent = Intent(this, CadastrarCliente ::class.java)
        startActivity(intent)
    }

    fun btn_Veiculo(){
        var intent = Intent(this, CadastrarVeiculo ::class.java)
        startActivity(intent)
    }
}
