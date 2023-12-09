package br.edu.ifsp.scl.agendaroom.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ContatoDAO {
    @Insert
    suspend fun insert(contato: Contato)

    @Query("SELECT * FROM contato ORDER BY nome")
    fun getAllContacts(): LiveData<List<Contato>>

    @Query("SELECT * FROM contato WHERE id=:id")
    fun getContactById(id: Int): LiveData<Contato>

}