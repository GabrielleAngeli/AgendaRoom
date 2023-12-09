package br.edu.ifsp.scl.agendaroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.databinding.FragmentDetalheBinding
import br.edu.ifsp.scl.agendaroom.viewmodel.ContatoViewModel

class DetalheFragment : Fragment() {
    private var _binding: FragmentDetalheBinding? = null
    private val binding get() = _binding!!
    lateinit var contato: Contato
    lateinit var nomeEditText: EditText
    lateinit var foneEditText: EditText
    lateinit var emailEditText: EditText
    lateinit var viewModel: ContatoViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ContatoViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        // Inflate the layout for this fragment
    _binding = FragmentDetalheBinding.inflate(inflater, container, false)
    return binding.root
}
override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    nomeEditText = binding.commonLayout.editTextNome
    foneEditText = binding.commonLayout.editTextFone
    emailEditText = binding.commonLayout.editTextEmail
    val idContato = requireArguments().getInt("idContato")
    viewModel.getContactById(idContato)
    viewModel.contato.observe(viewLifecycleOwner) { result ->
        result?.let {
            contato = result
            nomeEditText.setText(contato.nome)
            foneEditText.setText(contato.fone)
            emailEditText.setText(contato.email)
        }
    }
}

}