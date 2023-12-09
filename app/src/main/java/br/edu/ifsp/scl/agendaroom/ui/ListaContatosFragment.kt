package br.edu.ifsp.scl.agendaroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.ifsp.scl.agendaroom.R
import br.edu.ifsp.scl.agendaroom.adapter.ContatoAdapter
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.databinding.FragmentListaContatosBinding
import br.edu.ifsp.scl.agendaroom.viewmodel.ContatoViewModel

class ListaContatosFragment : Fragment() {
    private var _binding: FragmentListaContatosBinding? = null
    private val binding get() = _binding!!
    lateinit var contatoAdapter: ContatoAdapter
    lateinit var viewModel: ContatoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listaContatosFragment_to_cadastroFragment) }

        configureRecyclerView()

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        configureRecyclerView()

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                // Add menu items here
                menuInflater.inflate(R.menu.main_menu, menu)
                val searchView = menu.findItem(R.id.action_search).actionView as SearchView

                searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(p0: String?): Boolean {
                        TODO("Not yet implemented")
                    }
                    override fun onQueryTextChange(p0: String?): Boolean {
                        contatoAdapter.filter.filter(p0)
                        return true
                    }
                })
            }
            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun configureRecyclerView()
    {
        viewModel = ViewModelProvider(this).get(ContatoViewModel::class.java)
        viewModel.allContacts.observe(viewLifecycleOwner) { list ->
            list?.let {
                contatoAdapter.updateList(list as ArrayList<Contato>)
            }
        }
        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        contatoAdapter = ContatoAdapter()
        recyclerView.adapter = contatoAdapter

        val listener = object : ContatoAdapter.ContatoListener {
            override fun onItemClick(pos: Int) {
                val c = contatoAdapter.contatosListaFilterable[pos]
                val bundle = Bundle()
                bundle.putInt("idContato", c.id)
                findNavController().navigate(
                    R.id.action_listaContatosFragment_to_detalheFragment,
                    bundle
                )
            }
        }
        contatoAdapter.setClickListener(listener)

    }

}