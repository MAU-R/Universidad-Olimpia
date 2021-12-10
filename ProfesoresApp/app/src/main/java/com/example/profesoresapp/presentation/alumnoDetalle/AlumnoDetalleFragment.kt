package com.example.profesoresapp.presentation.alumnoDetalle

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.profesoresapp.R
import com.example.profesoresapp.core.extension.failure
import com.example.profesoresapp.core.extension.observe
import com.example.profesoresapp.core.presentation.BaseFragment
import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.databinding.AlumnoDetalleFragmentBinding
import com.example.profesoresapp.databinding.DetalleFragmentBinding
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.TwoIds
import com.example.profesoresapp.presentation.Detalle.MateriaDetailViewState
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import java.util.logging.Logger

@AndroidEntryPoint
@WithFragmentBindings
class AlumnoDetalleFragment :  BaseFragment(R.layout.alumno_detalle_fragment) {

    private lateinit var binding: AlumnoDetalleFragmentBinding
    private val args : AlumnoDetalleFragmentArgs by navArgs()
    private lateinit var detalleIngreso:DetallesMateria
    private val alumnosViewModel by viewModels<AlumnoDetalleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alumnosViewModel.apply {
            observe(state, ::onViewStateChanged)
            failure(failure, ::handleFailure)
        }

    }

    override fun onResume() {
        super.onResume()
        val ids=TwoIds(args.matricula,args.alumno.idAlumno)
        alumnosViewModel.doGetDetalleMateria(ids)
    }

    override fun onViewStateChanged(state: BaseViewState?) {
        super.onViewStateChanged(state)
        when (state) {
            is AlumnoDetalleViewState.detalleRecieved -> {
                detalleIngreso=state.detalle
                binding.edtC1.setText(state.detalle.calificacion1.toString())
                binding.edtC2.setText(state.detalle.calificacion2.toString())
                binding.edtC3.setText(state.detalle.calificacion3.toString())
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
        binding = AlumnoDetalleFragmentBinding.bind(view)



        binding.lifecycleOwner = this

        binding.apply {
            btnGuardar.setOnClickListener {
                detalleIngreso.calificacion1=binding.edtC1.text.toString().toDouble()
                detalleIngreso.calificacion2=binding.edtC2.text.toString().toDouble()
                detalleIngreso.calificacion3=binding.edtC3.text.toString().toDouble()
                Log.d("Variable esta", detalleIngreso.calificacion1.toString())
                alumnosViewModel.doSaveDetalle(detalleIngreso)
                navController.popBackStack()
            }
            user=args.alumno
        }

        baseActivity.setBottomNavVisibility(View.VISIBLE)
    }
private fun save(){

}
}