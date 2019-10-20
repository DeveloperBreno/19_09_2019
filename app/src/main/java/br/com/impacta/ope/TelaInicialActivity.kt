package br.com.impacta.ope

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        setSupportActionBar(toolbar)
        val actionbar = supportActionBar
        actionbar?.title = "Inicio"
        actionbar?.setDisplayHomeAsUpEnabled(true)
        configuraMenuLateral()
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
            Toast.makeText(this, "Localizar", Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Atualizado", Toast.LENGTH_SHORT).show()


        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()


        } else if (id == R.id.action_sair) {
            Toast.makeText(
                this, "Aplicativo encerrado.",
                Toast.LENGTH_SHORT
            ).show()
            finishAffinity()
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_reparo -> {
                Toast.makeText(
                    this,
                    "Clicou em Manutenção",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.nav_forum -> {
                Toast.makeText(
                    this,
                    "Clicou em Fórum",
                    Toast.LENGTH_SHORT
                ).show()
            }
            R.id.nav_vendedores ->{
                Toast.makeText(
                    this,
                    "Clicou em Vendedores",
                    Toast.LENGTH_SHORT
                ).show()
            }

            R.id.nav_returnLogin -> {
                Toast.makeText(
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
