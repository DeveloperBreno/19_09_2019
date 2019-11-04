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

        val dao = DatabaseManager.getVeiculosDAO()

        return dao.findAll()
    }


    fun save(veiculo: Veiculos) : Response? {

        val dao = DatabaseManager.getVeiculosDAO()

        dao.insert(veiculo)

        return null
    }


    fun delete(veiculo: Veiculos): Response? {

        val dao = DatabaseManager.getVeiculosDAO()

        dao.delete(veiculo)

        return null
    }



    inline fun <reified T> parseJson(json: String): T {
        val type = object : TypeToken<T>() {}.type
        return Gson().fromJson<T>(json, type)
    }

}


