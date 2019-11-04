package br.com.impacta.ope

import android.arch.persistence.room.Room


object DatabaseManager {

    private var dbInstance: OficinaDataBase

    init {

        val appContext = LMSApplication.getInstance().applicationContext

        dbInstance = Room.databaseBuilder(
            appContext,
            OficinaDataBase::class.java,
            "oficina.sqlite"

        ).build()
    }

    fun getVeiculosDAO(): VeiculosDAO{

        return dbInstance.veiculosDao()
    }
}