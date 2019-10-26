package br.com.impacta.ope

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_veiculo.*

class VeiculoNewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_veiculo)

        botao_salvar.setOnClickListener {

            var d = Veiculos()
            d.nomeModelo = campo_nomeModelo.text.toString()
            d.nomeMarca = campo_nomeMarca.text.toString()
            d.placa = campo_placa.text.toString()
            d.foto = campo_imagem.text.toString()


            Thread{

                VeiculosService.save(d)

                runOnUiThread{
                    finish()
                }

            }.start()

        }

    }
}
