package com.example.a19_09_2019
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        btncadastrarcliente.setOnClickListener {btn()}
    }
    fun btn(){
        var cpf = nomecliente.text.toString()
        var senha = senha.text.toString()
        if (cpf == "" && senha == ""){
            Toast.makeText(this, "Bem vindo ", Toast.LENGTH_LONG).show()

            //Toast.makeText(this, "Clicou no botao",  Toast.LENGTH_SHORT).show()
            //Toast.makeText(this, "Olá Breno", Toast.LENGTH_SHORT).show()
            var intent = Intent(this, Dashboard::class.java)
            var params = Bundle ()
            params.putString("nome_usuario", cpf)
            params.putInt("numero", 10)
            params.putIntArray("array_int", intArrayOf(1,2,3))
            intent.putExtras(params)
            startActivity(intent)
            //setContentView(R.layout.dashboard)


        }else{
            Toast.makeText(this, "CPF ou Senha invalidas", Toast.LENGTH_SHORT).show()
        }
    }
}