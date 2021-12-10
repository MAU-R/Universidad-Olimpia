package com.example.alumnosapp.presentation.detalle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.alumnosapp.R
import com.example.alumnosapp.core.extension.failure
import com.example.alumnosapp.core.extension.observe
import com.example.alumnosapp.core.presentation.BaseFragment
import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.databinding.DetalleFragmentBinding
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.TwoIds
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings


@AndroidEntryPoint
@WithFragmentBindings

class DetalleFragment : BaseFragment(R.layout.detalle_fragment) {

    private lateinit var binding: DetalleFragmentBinding
    private val args : DetalleFragmentArgs by navArgs()
    private lateinit var detalleIngreso: DetallesMateria
    private val detalleViewModel by viewModels<DetalleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detalleViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun onResume() {
        super.onResume()
        binding.clase=args.clase
        detalleViewModel.doGetDetallesMateria(args.clase.idMateria)
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is DetalleViewState.detalleRecieved -> {
                detalleIngreso=state.detalle
                binding.txc1.setText(state.detalle.calificacion1.toString())
                binding.txc2.setText(state.detalle.calificacion2.toString())
                binding.txc3.setText(state.detalle.calificacion3.toString())
            }
        }
    }

    private fun setUpAdapter(alumnos: List<Alumno>) {
        /*     adapter.addData(alumnos)
             adapter.setListener {
                 navController.navigate(
                     DetalleFragmentDirections.actionDetalleFragmentToAlumnoDetalleFragment(it,args.clase.idMateria)
                 )
             }

             binding.rcAlumnos.apply {
                 adapter = this@DetalleFragment.adapter
             }
     */
    }

    override fun setBinding(view: View) {
        binding = DetalleFragmentBinding.bind(view)



        binding.lifecycleOwner = this

        binding.apply {


        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }
    private fun save(){

    }
}