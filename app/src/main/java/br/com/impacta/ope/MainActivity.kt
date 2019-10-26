package br.com.impacta.ope

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*







class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnEntrar.setOnClickListener{botaoLogin()}

    }

    fun botaoLogin(){
        var aluno = nomeCliente.text.toString()
        var senha = senhaCliente.text.toString()

        if (aluno == "aluno" && senha == "impacta"){
            Toast.makeText(
                this, "Seja Bem Vindo: $aluno", Toast.LENGTH_LONG).show()
            var intent = Intent(this, TelaInicialActivity ::class.java)
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


