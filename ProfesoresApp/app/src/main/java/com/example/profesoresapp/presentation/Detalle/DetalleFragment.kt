package com.example.profesoresapp.presentation.Detalle

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.DetalleFragmentBinding
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.TwoIds

import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class DetalleFragment :  BaseFragment(R.layout.detalle_fragment) {

    private lateinit var binding: DetalleFragmentBinding
    private val args : DetalleFragmentArgs by navArgs()
    private val adapter: MateriaDetailAdapter by lazy { MateriaDetailAdapter() }
    private val materiasViewModel by viewModels<DetalleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        materiasViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }
    }

    override fun onResume() {
        super.onResume()
        binding.clase= args.clase
        materiasViewModel.doGetDetalleMateria(args.clase.idMateria)
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
             navController.navigate(
                DetalleFragmentDirections.actionDetalleFragmentToAlumnoDetalleFragment(it,args.clase.idMateria)
             )
        }

        binding.rcAlumnos.apply {
            adapter = this@DetalleFragment.adapter
        }

    }

    override fun setBinding(view: View) {
        binding = DetalleFragmentBinding.bind(view)



        binding.lifecycleOwner = this

        binding.apply {

        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }

}