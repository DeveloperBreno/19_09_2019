package br.com.impacta.ope

import android.content.Context


object ManutencaoService {

    fun getCarros(context: Context): List<Manutencao> {
        val carros = mutableListOf<Manutencao>()

        // criar 10 disciplinas
        for (i in 1..10) {
            val d = Manutencao()
            d.nome = "Manutencao $i"
            d.ementa = "Ementa Manutencao $i"
            d.CarroMaster = "carros fodas $i"
            d.foto = "https://cdn.wallpapersafari.com/89/14/F2mIx0.jpg"
            carros.add(d)
        }

        return carros

    }
}


