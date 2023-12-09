package br.edu.ifsp.scl.agendaroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.edu.ifsp.scl.agendaroom.R
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.databinding.FragmentDetalheBinding
import br.edu.ifsp.scl.agendaroom.viewmodel.ContatoViewModel
import com.google.android.material.snackbar.Snackbar

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
        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.detalhe_menu, menu)
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                // Handle the menu selection
                return when (menuItem.itemId) {
                    R.id.action_alterarContato -> {
                        contato.nome = nomeEditText.text.toString()
                        contato.fone = foneEditText.text.toString()
                        contato.email = emailEditText.text.toString()
                        viewModel.update(contato)
                        Snackbar.make(binding.root, "Contato alterado", Snackbar.LENGTH_SHORT)
                            .show()
                        findNavController().popBackStack()
                        true
                    }

                    R.id.action_excluirContato -> {
                        viewModel.delete(contato)
                        Snackbar.make(binding.root, "Contato apagado", Snackbar.LENGTH_SHORT).show()
                        findNavController().popBackStack()
                        true
                    }

                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

}