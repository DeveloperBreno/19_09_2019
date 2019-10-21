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
    private var carros = listOf<Manutencao>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)



        setSupportActionBar(toolbar)

        val actionbar = supportActionBar

        actionbar?.title = "Inicio"

        actionbar?.setDisplayHomeAsUpEnabled(false)

        configuraMenuLateral()

        //Configuração CardView
        recyclerCarros?.layoutManager = LinearLayoutManager(context)
        recyclerCarros?.itemAnimator = DefaultItemAnimator()
        recyclerCarros?.setHasFixedSize(true)
    }


    override fun onResume() {
        super.onResume()

        taskCarros()
    }
    fun taskCarros() {
        carros = ManutencaoService.getCarros(context)
        recyclerCarros?.adapter =ManutencaoAdapter(carros) { onClickCarros(it) }
    }
    fun onClickCarros(carros: Manutencao) {
        makeText1(context, "Clicou nos carros ${carros.nome}",Toast.LENGTH_SHORT).show()
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
        menuInflater.inflate(R.menu.menu_main, menu)


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
            R.id.card_Carros -> {
                makeText1(
                    this,
                    "Clicou em carros",
                    Toast.LENGTH_SHORT
                ).show()
            }
            R.id.nav_reparo -> {
                val intent = Intent(this, ManutencaoActivity::class.java)
                startActivity(intent)
            }

            R.id.nav_forum -> {
                makeText1(
                    this,
                    "Clicou em Fórum",
                    Toast.LENGTH_SHORT
                ).show()
            }
            R.id.nav_vendedores ->{
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
