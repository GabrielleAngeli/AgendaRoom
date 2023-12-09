package br.edu.ifsp.scl.agendaroom.repository

import androidx.lifecycle.LiveData
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.data.ContatoDAO

class ContatoRepository (private val contatoDAO: ContatoDAO) {
    suspend fun insert(contato: Contato){
        contatoDAO.insert(contato)
    }

    fun getAllContacts(): LiveData<List<Contato>> {
        return contatoDAO.getAllContacts()
    }

}
