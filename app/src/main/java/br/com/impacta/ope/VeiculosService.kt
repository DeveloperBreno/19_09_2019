package br.com.impacta.ope

import android.content.Context
import android.util.Log
import br.com.fernandosousa.lmsapp.HttpHelper
import br.com.fernandosousa.lmsapp.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL


object VeiculosService {

    val host = "https://b3sc.pythonanywhere.com/"
    val TAG = "WS_LMSApp"

    fun getCarros(context: Context): List<Veiculos> {

        val veiculos = mutableListOf<Veiculos>()

        val url = "$host/veiculos"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        return parseJson<List<Veiculos>>(json)
    }


    fun save(veiculo: Veiculos) : Response{
        val  veiculo_json = veiculo.toJson()
        val retorno = HttpHelper.post("$host/veiculos", veiculo_json)

        return parseJson <Response>(retorno)
    }


    fun delete(veiculo: Veiculos): Response {
        Log.d(TAG, veiculo.id.toString())
        val url = "$host/veiculos/${veiculo.id}"
        val json = HttpHelper.delete(url)
        Log.d(TAG, json)
        return parseJson(json)
    }



    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }

//    fun getCarros(): List<Veiculos> {
//        val carros = mutableListOf<Veiculos>()
//
//        // criar 10 disciplinas
//        for (i in 1..10) {
//            val d = Veiculos()
//            d.nomeModelo = "Veiculos $i"
//            d.placa = "Ementa Veiculos $i"
//            d.CarroMaster = "carros fodas $i"
//            d.foto = "https://cdn.wallpapersafari.com/89/14/F2mIx0.jpg"
//            carros.add(d)
//        }
//
//        return carros
//    }
}


