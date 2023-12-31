package br.edu.ifsp.scl.agendaroom.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.data.ContatoDatabase
import br.edu.ifsp.scl.agendaroom.repository.ContatoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ContatoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ContatoRepository
    var allContacts : LiveData<List<Contato>>
    lateinit var contato : LiveData<Contato>
    init {
        val dao = ContatoDatabase.getDatabase(application).contatoDAO()
        repository = ContatoRepository(dao)
        allContacts = repository.getAllContacts()
    }
    fun insert(contato: Contato) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(contato)
    }

    fun update(contato: Contato) = viewModelScope.launch(Dispatchers.IO){
        repository.update(contato)
    }
    fun delete(contato: Contato) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(contato)
    }

    fun getContactById(id: Int) {
        viewModelScope.launch {
            contato = repository.getContactById(id)
        }
    }
}
