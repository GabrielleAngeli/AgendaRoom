package br.edu.ifsp.scl.agendaroom.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.ifsp.scl.agendaroom.data.Contato
import br.edu.ifsp.scl.agendaroom.databinding.ContatoCelulaBinding

class ContatoAdapter(): RecyclerView.Adapter<ContatoAdapter.ContatoViewHolder>() {
    private lateinit var binding: ContatoCelulaBinding

    var listener: ContatoListener?=null

    var contatosLista = ArrayList<Contato>()
    var contatosListaFilterable = ArrayList<Contato>()

    fun updateList(newList: ArrayList<Contato>) {
        contatosLista = newList
        contatosListaFilterable = contatosLista
        notifyDataSetChanged()
    }

    fun setClickListener(listener: ContatoListener)
    {
        this.listener = listener
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContatoViewHolder {
        binding = ContatoCelulaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContatoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.nomeVH.text = contatosLista[position].nome
        holder.foneVH.text = contatosLista[position].fone
    }

    override fun getItemCount(): Int {
        return contatosLista.size
    }

    inner class ContatoViewHolder(view: ContatoCelulaBinding) : RecyclerView.ViewHolder(view.root) {
        val nomeVH = view.nome
        val foneVH = view.fone
        init {
            view.root.setOnClickListener {
                listener?.onItemClick(adapterPosition)
            }
        }

    }

    interface ContatoListener
    {
        fun onItemClick(pos: Int)
    }
}