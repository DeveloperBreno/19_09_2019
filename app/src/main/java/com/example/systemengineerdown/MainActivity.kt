package com.example.systemengineerdown

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnEntrar.setOnClickListener{btn_login()}
    }

    fun btn_login(){
        var aluno = nomecliente.text.toString()
        var senha = senha.text.toString()

        if (aluno == "aluno" && senha == "impacta"){
            Toast.makeText(
                this, "Seja Bem Vindo: $aluno", Toast.LENGTH_LONG).show()
            var intent = Intent(this, DashboardActivity ::class.java)
            startActivity(intent)

        } else if (aluno != "aluno" && senha == "impacta"){
            Toast.makeText(
                this,"Usuário Incorreto!", Toast.LENGTH_LONG
            ).show()

        }else if (aluno == "aluno" && senha != "impacta"){
            Toast.makeText(
                this,"Senha Incorreta!", Toast.LENGTH_LONG
            ).show()

        }else{
            Toast.makeText(this,"Dados Inválidos !!!", Toast.LENGTH_LONG).show()
        }
    }
}