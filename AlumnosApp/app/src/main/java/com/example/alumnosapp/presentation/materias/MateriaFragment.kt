package com.example.alumnosapp.presentation.materias

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.example.alumnosapp.R
import com.example.alumnosapp.core.extension.failure
import com.example.alumnosapp.core.extension.observe
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.databinding.MateriaFragmentBinding
import com.example.alumnosapp.domain.model.Materia
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class MateriaFragment : BaseFragment(R.layout.materia_fragment) {

    private lateinit var binding: MateriaFragmentBinding

    private lateinit var adapter: MateriaAdapter
    private val materiaViewModel by viewModels<MateriaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        materiaViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
            materiaViewModel.doGetMateriasByName("")
        }
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is MateriaViewState.MateriasReceived -> setUpAdapter(state.materias)
        }
    }

    private fun setUpAdapter(cocktails: List<Materia>) {
        adapter = MateriaAdapter()

        adapter.addData(cocktails)

        binding.rcMaterias.apply {
            adapter = this@MateriaFragment.adapter
        }
    }

    override fun setBinding(view: View) {
        binding = MateriaFragmentBinding.bind(view)

        binding.lifecycleOwner = this

    }
}