package com.example.profesoresapp.presentation.Detalle

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.MateriaFragmentBinding
import com.example.profesoresapp.databinding.MateriadetailFragmentBinding
import com.example.profesoresapp.databinding.RowMateriasBinding
import com.example.profesoresapp.databinding.RxAlumnoBinding
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.presentation.materias.MateriaAdapter
import com.example.profesoresapp.presentation.materias.MateriaFragmentDirections
import com.example.profesoresapp.presentation.materias.MateriaViewModel
import com.example.profesoresapp.presentation.materias.MateriaViewState
@SuppressLint("NotifyDataSetChanged")
class MateriaDetailAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list: MutableList<Alumno> = mutableListOf()
    private lateinit var listener: (alumno: Alumno) -> Unit

    fun addData(list: List<Alumno>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun setListener(listener: (alumno: Alumno) -> Unit) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolderItem(
        RxAlumnoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as ViewHolderItem).bind(list[position], listener)

    override fun getItemCount() = list.size

    class ViewHolderItem(private val binding: RxAlumnoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Alumno, listener: (alumno: Alumno) -> Unit) {
            binding.item = data
            binding.root.setOnClickListener { listener(data) }
        }
    }
}