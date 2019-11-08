package br.com.impacta.ope

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_new_veiculo.*
import kotlinx.android.synthetic.main.activity_new_veiculo.Abrircamera


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

        Abrircamera.setOnClickListener{
            var i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(i, 123)
        }


    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 123){
            var bmp = data?.extras?.get("data") as Bitmap
            imagem2.setImageBitmap(bmp)
        }
    }


}
