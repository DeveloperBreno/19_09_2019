package br.com.impacta.ope



import com.google.gson.GsonBuilder
import java.io.Serializable

class Veiculos : Serializable {

    var id:Long = 0
    var nomeModelo = ""
    var placa = ""
    var foto = ""
    var nomeMarca = ""
    var CarroMaster = ""

    override fun toString(): String {
        return "Veiculos(nomeModelo='$nomeModelo')"
    }

    fun toJson() : String{
        return GsonBuilder().create().toJson(this)
    }
}