package com.example.profesoresapp.presentation.detalleMateria

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.MateriaFragmentBinding
import com.example.profesoresapp.databinding.MateriadetailFragmentBinding
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.presentation.materias.MateriaFragmentDirections
import com.example.profesoresapp.presentation.materias.MateriaViewModel
import com.example.profesoresapp.presentation.materias.MateriaViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
@WithFragmentBindings
class MateriaDetailFragment : BaseFragment(R.layout.materiadetail_fragment) {

    private lateinit var binding: MateriadetailFragmentBinding

    private val adapter: MateriaDetailAdapter by lazy { MateriaDetailAdapter() }
    private val materiasViewModel by viewModels<MateriaDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        materiasViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        materiasViewModel.doGetAlumnosPorMateria("2021-12-041")
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is MateriaDetailViewState.alumnosReceived -> setUpAdapter(state.alumnos)
        }
    }

    private fun setUpAdapter(alumnos: List<Alumno>) {
        adapter.addData(alumnos)

        adapter.setListener {
           /* navController.navigate(

            )*/
        }

        binding.rcAlumnos.apply {
           // isVisible = alumnos.isNotEmpty()
            adapter = this@MateriaDetailFragment.adapter
        }

    }

    override fun setBinding(view: View) {
        binding = MateriadetailFragmentBinding.bind(view)



        binding.lifecycleOwner = this

        binding.apply {

        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }
}
