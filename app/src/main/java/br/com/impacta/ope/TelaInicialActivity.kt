package br.com.impacta.ope

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.activity_tela_inicial.recyclerCarros
import kotlinx.android.synthetic.main.toolbar.*
import android.widget.Toast.makeText as makeText1


class TelaInicialActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    private var carros = listOf<Veiculos>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        recyclerCarros?.layoutManager = LinearLayoutManager(context)
        recyclerCarros?.itemAnimator = DefaultItemAnimator()
        recyclerCarros?.setHasFixedSize(true)


        setSupportActionBar(toolbar)

        val actionbar = supportActionBar

        actionbar?.title = "Inicio"

        actionbar?.setDisplayHomeAsUpEnabled(false)

        configuraMenuLateral()
    }


    override fun onResume() {
        super.onResume()
        // task para recuperar as disciplinas
        taskCarros()
    }

    fun taskCarros() {

        Thread {
            this.carros =
                VeiculosService.getCarros(context)

            runOnUiThread {
                // atualizar lista
                recyclerCarros?.adapter =
                    VeiculosAdapter(carros) {
                        onClickCarros(it)
                    }
            }
        }.start()
    }

    // tratamento do evento de clicar em uma disciplina
    fun onClickCarros(carros: Veiculos) {
        Toast.makeText(context, "Clicou carros ${carros.nomeModelo}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, VeiculosUActivity::class.java)
        intent.putExtra("carros", carros)
        startActivity(intent)
    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layoutMenuLateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )
        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()
        menu_lateral.setNavigationItemSelectedListener(this)
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_superior, menu)


        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            makeText1(this, "Localizar", Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_atualizar) {
            makeText1(this, "Atualizado", Toast.LENGTH_SHORT).show()


        } else if (id == R.id.action_config) {
        makeText1(this, "Configurações", Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_incluir) {
            var it = Intent(this, VeiculoNewActivity::class.java)
            startActivity(it)


        } else if (id == R.id.action_sair) {
            makeText1(
                this, "Aplicativo encerrado.",
                Toast.LENGTH_SHORT
            ).show()
            finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_manutencao -> {
                var intentV = Intent(this, VeiculosActivity::class.java)
                startActivity(intentV)

//                makeText1(
//                    this,
//                    "Clicou em carros",
//                    Toast.LENGTH_SHORT
//                ).show()
            }


            R.id.nav_vendedores -> {
                makeText1(
                    this,
                    "Clicou em Vendedores",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.nav_returnLogin -> {
                makeText1(
                    this,
                    "Usuário Deslogado",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }

        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)

        return true
    }


}
