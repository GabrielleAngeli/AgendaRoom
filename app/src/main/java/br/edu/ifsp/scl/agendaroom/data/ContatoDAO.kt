package br.edu.ifsp.scl.agendaroom.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface ContatoDAO {
    @Insert
    suspend fun insert(contato: Contato)
}