package br.com.impacta.ope

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase


@Database(entities = arrayOf(Veiculos::class), version = 1)
abstract class OficinaDataBase: RoomDatabase() {

    abstract fun veiculosDao(): VeiculosDAO

}