package br.edu.ifsp.scl.agendaroom.repository

import androidx.lifecycle.LiveData
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.data.ContatoDAO

class ContatoRepository (private val contatoDAO: ContatoDAO) {
    suspend fun insert(contato: Contato){
        contatoDAO.insert(contato)
    }

    suspend fun update(contato: Contato){
        contatoDAO.update(contato)
    }

    suspend fun delete(contato: Contato){
        contatoDAO.delete(contato)
    }

    fun getAllContacts(): LiveData<List<Contato>> {
        return contatoDAO.getAllContacts()
    }

    fun getContactById(id: Int): LiveData<Contato>{
        return contatoDAO.getContactById(id)
    }
}
