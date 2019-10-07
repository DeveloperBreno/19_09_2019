package com.example.a19_09_2019

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.systemengineerdown.R
import kotlinx.android.synthetic.main.cadastrarcliente.*


class CadastrarCliente : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cadastrarcliente)
        btncadastrarcliente.setOnClickListener {cadastrarcliente()}

        val params = intent.extras
        val nome = params?.getString("nome_usuario")
        val n = params?.getString("numero")

        supportActionBar?.title = "Cadastrar cliente"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    fun cadastrarcliente(){
        var donoid = nomecliente.text.toString()
        var cpf = cpfcliente.text.toString()

        if (donoid.length > 3 && cpf.length > 10){
            Toast.makeText(this, "Cliente $donoid cadastrado!", Toast.LENGTH_LONG).show()
            var intent = Intent(this, Dashboard_fun::class.java)
            var params = Bundle ()
            params.putString("nome_usuario", "")
            params.putInt("numero", 10)
            params.putIntArray("array_int", intArrayOf(1,2,3))
            intent.putExtras(params)
            startActivity(intent)
        }else{
            Toast.makeText(this, "Preencha corretamente!", Toast.LENGTH_LONG).show()

        }

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