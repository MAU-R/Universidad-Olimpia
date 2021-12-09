package com.example.alumnosapp.presentation.materias

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.alumnosapp.core.utils.LayoutType
import com.example.alumnosapp.databinding.RowMateriasBinding
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.Materia

@SuppressLint("NotifyDataSetChanged")
class MateriaAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Materia> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    fun addData(list: List<Materia>) {
        this.list = list.toMutableList()

        notifyDataSetChanged()
    }

    fun changeView(layoutType: LayoutType) {
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RowMateriasBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder).bind(
            list[position]
        )

    override fun getItemCount() = list.size
}

class ViewHolderItem(private val binding: RowMateriasBinding) :
    BaseViewHolder(binding.root) {

    override fun bind(data: Materia) {
        binding.item = data
    }
}

abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {

    abstract fun bind(data: Materia)

}