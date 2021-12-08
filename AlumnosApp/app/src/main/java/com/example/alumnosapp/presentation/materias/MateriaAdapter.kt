package com.example.alumnosapp.presentation.materias

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amalip.cocktailapp.core.utils.LayoutType
import com.example.alumnosapp.databinding.RowMateriasBinding
import com.example.alumnosapp.domain.model.Materia
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@SuppressLint("NotifyDataSetChanged")
class MateriaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Materia> = mutableListOf()
    private lateinit var listener: (category: Materia) -> Unit

    fun addData(list: List<Materia>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setListener(listener: (materia: Materia) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowMateriasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolderItem).bind(list[position], listener)

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RowMateriasBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Materia, listener: (materia: Materia) -> Unit) {
            binding.item = data

            binding.root.setOnClickListener { listener(data) }
        }
    }
}