package com.example.alumnosapp.presentation.materias

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.amalip.cocktailapp.core.utils.LayoutType
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

    private val adapter: MateriaAdapter by lazy { MateriaAdapter() }
    private val materiasViewModel by viewModels<MateriaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        materiasViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        materiasViewModel.doGetMateriasByName("")
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is MateriaViewState.MateriasReceived -> setUpAdapter(state.materias)
        }
    }

    private fun setUpAdapter(materias: List<Materia>) {
        binding.emptyView.isVisible = materias.isEmpty()

        adapter.addData(materias)

        adapter.setListener {
            navController.navigate(
                MateriaFragmentDirections.actionMateriaFragmentToMateriaDetailFragment(
                    //it.name
                )
            )
        }

        binding.rcMaterias.apply {
            isVisible = materias.isNotEmpty()
            adapter = this@MateriaFragment.adapter
        }

    }

    override fun setBinding(view: View) {
        binding = MateriaFragmentBinding.bind(view)

        setHasOptionsMenu(true)

        binding.lifecycleOwner = this

        binding.apply {
            swpRefresh.apply {
                setOnRefreshListener {

                    isRefreshing = false
                }
            }
        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }


}