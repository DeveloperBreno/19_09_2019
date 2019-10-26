package br.com.impacta.ope


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.view.Menu
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_veiculos_u.*
import kotlinx.android.synthetic.main.toolbar.*

class VeiculosUActivity : AppCompatActivity() {

    var carros: Veiculos? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_veiculos_u)

        // recuperar onjeto de Disciplina da Intent
        carros = intent.getSerializableExtra("carros") as Veiculos

        // configurar título com nomeModelo da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        // alterar título da ActionBar
        supportActionBar?.title = carros?.nomeModelo

        // up navigation
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // atualizar dados da disciplina
        nomeCarros.text = carros?.nomeModelo
        Picasso.with(this).load(carros?.foto).fit().into(cardImg,
            object : com.squareup.picasso.Callback {
                override fun onSuccess() {}

                override fun onError() {}
            })
    }

    // método sobrescrito para inflar o menu na Actionbar
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.fragmento_remover, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // id do item clicado
        val id = item?.itemId
        // verificar qual item foi clicado
        // remover a cotacao no WS
        if  (id == R.id.action_excluir) {
            // alerta para confirmar a remeção
            // só remove se houver confirmação positiva
            AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage("Deseja excluir a cotacao")
                .setPositiveButton("Sim") {
                        dialog, which ->
                    dialog.dismiss()
                    taskExcluir()
                }.setNegativeButton("Não") {
                        dialog, which -> dialog.dismiss()
                }.create().show()
        }else if (id == android.R.id.home) {
            finish() //chama o onDestroy para a activity
        }
        return super.onOptionsItemSelected(item)
    }

    private fun taskExcluir() {
        if (this.carros != null && this.carros is Veiculos) {
            // Thread para remover o veiculo
            Thread {
                VeiculosService.delete(this.carros as Veiculos)
                runOnUiThread {
                    // voltar para activity anterior
                    finish()
                }
            }.start()
        }
    }


}

