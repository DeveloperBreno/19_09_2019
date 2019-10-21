package br.com.impacta.ope

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.toolbar.*

class ManutencaoActivity : AppCompatActivity() {

    private val context: Context get() = this
    private var manutencao = listOf<Manutencao>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.teste_activity)



        setSupportActionBar(toolbar)
        //Alterar o Titulo ActionBar
        supportActionBar?.title = "Manutenção"
        supportActionBar?.setDisplayShowTitleEnabled(true)

        //Configurações do CardView
        recyclerCarros?.layoutManager = LinearLayoutManager(context)
        recyclerCarros?.itemAnimator = DefaultItemAnimator()
        recyclerCarros?.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskManutencao()
    }

    fun taskManutencao() {

//        Thread{
//            this.manutencao = ManutencaoService.getCarros(context)
//
//            runOnUiThread{
//                //Atualização da Lista
//                recyclerCarros?.adapter = ManutencaoAdapter(manutencao){
//                    onClickManutencao(it)
//                }
//            }
//        }.start()

        manutencao = ManutencaoService.getCarros(context)
        recyclerCarros?.adapter = ManutencaoAdapter(manutencao) { onClickManutencao(it) }
    }

    //
    fun onClickManutencao(manutencao: Manutencao) {
        Toast.makeText(context, "Clicou em manutenção ${manutencao.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, ManutencaoSelectActivity::class.java)
        intent.putExtra("manutencao", manutencao)
        startActivity(intent)
    }
}