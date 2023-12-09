package br.edu.ifsp.scl.agendaroom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.edu.ifsp.scl.agendaroom.R
import br.edu.ifsp.scl.agendaroom.databinding.FragmentListaContatosBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaContatosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaContatosFragment : Fragment() {
    private var _binding: FragmentListaContatosBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListaContatosBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_listaContatosFragment_to_cadastroFragment) }
        return root
    }

}