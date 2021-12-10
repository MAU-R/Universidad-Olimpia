package com.example.profesoresapp.presentation.alumnoDetalle

import androidx.lifecycle.ViewModel
import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.TwoIds
import com.example.profesoresapp.domain.usecase.GetAlumnosPorMateria
import com.example.profesoresapp.domain.usecase.getDetalleMateria
import com.example.profesoresapp.domain.usecase.getLocalUser
import com.example.profesoresapp.domain.usecase.saveCalificaciones
import com.example.profesoresapp.presentation.profesor.CuentaViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@HiltViewModel
@DelicateCoroutinesApi
class AlumnoDetalleViewModel @Inject constructor(
    private val getDetalleMateria: getDetalleMateria,
    private val saveCalificaciones: saveCalificaciones
) : BaseViewModel() {

    fun doGetDetalleMateria(ids: TwoIds){
        getDetalleMateria(ids){
            it.fold(::notFound){
                state.value=AlumnoDetalleViewState.detalleRecieved(it?: DetallesMateria())
                true
            }
        }
    }
    private fun notFound(failure: Failure){
        state.value= AlumnoDetalleViewState.NotFound
        handleFailure(failure = failure)
    }
    fun doSaveDetalle(detalle:DetallesMateria){
        saveCalificaciones(detalle){
            it.fold(::handleFailure){
                true
            }
        }
    }

}