package net.daan.recyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_lista_dentistas.view.*
import net.daan.recyclerview.R
import net.daan.recyclerview.model.Dentista

class DentistaRecyclerAdapter(var list: ArrayList<Dentista>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.layout_lista_dentistas, parent, false) // parent = recyclerView

        return DentistaViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is DentistaViewHolder -> {
                holder.bind(list[position])
            }
        }
    }

    class DentistaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val txtNome: TextView = itemView.txtNome
        val txtEmail: TextView = itemView.txtEmail

        fun bind(dentista: Dentista) {
            txtNome.text = dentista.nome
            txtEmail.text = dentista.email
        }
    }
}