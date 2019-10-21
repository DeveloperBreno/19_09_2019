package br.com.impacta.ope


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_carros.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.teste_activity.*
import kotlinx.android.synthetic.main.toolbar.*


class ManutencaoSelectActivity : AppCompatActivity() {
//    val context = this

    var carros: Manutencao? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carros)


        carros = intent.getSerializableExtra("manutencao") as Manutencao

        // configurar título com nome da Disciplina e botão de voltar da Toobar
        // colocar toolbar
        setSupportActionBar(toolbar)

        supportActionBar?.title = carros?.nome

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        cardNome.text = carros?.nome
        Picasso.with(this).load(carros?.foto).fit().into(cardImg,
                object: com.squareup.picasso.Callback{
                    override fun onSuccess() { }

                    override fun onError() { }

                })
    }
}
