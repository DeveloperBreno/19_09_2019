package br.com.impacta.ope



import java.io.Serializable

class Manutencao : Serializable {

    var id:Long = 0
    var nome = ""
    var ementa = ""
    var foto = ""
    var CarroMaster = ""

    override fun toString(): String {
        return "Manutencao(nome='$nome')"
    }
}