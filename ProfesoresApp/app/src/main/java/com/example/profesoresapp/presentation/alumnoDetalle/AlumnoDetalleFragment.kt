package com.example.profesoresapp.presentation.alumnoDetalle

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.profesoresapp.R

class AlumnoDetalleFragment : Fragment() {

    companion object {
        fun newInstance() = AlumnoDetalleFragment()
    }

    private lateinit var viewModel: AlumnoDetalleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.alumno_detalle_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AlumnoDetalleViewModel::class.java)
        // TODO: Use the ViewModel
    }

}