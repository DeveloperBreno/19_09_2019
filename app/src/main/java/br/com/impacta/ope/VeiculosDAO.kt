package br.com.impacta.ope

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query


@Dao
interface VeiculosDAO {

    @Query("SELECT * FROM veiculos where id = :id")
    fun getById(id: Long): Veiculos?

    @Query("SELECT * FROM veiculos")
    fun findAll(): List<Veiculos>

    @Insert
    fun insert(veiculos: Veiculos)

    @Delete
    fun delete(veiculos: Veiculos)
}