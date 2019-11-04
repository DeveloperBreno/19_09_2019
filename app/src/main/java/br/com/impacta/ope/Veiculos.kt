package br.com.impacta.ope



import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable


@Entity(tableName ="veiculos")
class Veiculos : Serializable {

    @PrimaryKey
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