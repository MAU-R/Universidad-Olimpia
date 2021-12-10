package com.example.alumnosapp.presentation.detalle

import androidx.lifecycle.ViewModel
import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.model.TwoIds
import com.example.alumnosapp.domain.usecase.GetDetalleMateria
import com.example.alumnosapp.domain.usecase.getLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@HiltViewModel
@DelicateCoroutinesApi
class DetalleViewModel @Inject constructor(
  private val getDetalleMateria: GetDetalleMateria,
  private val getLocalUser: getLocalUser
) : BaseViewModel() {

    fun doGetDetallesMateria(id_materia:Int){
        getLocalUser(UseCase.None()){
            it.fold(::notFound){
                 val ids=TwoIds(id_materia, it.idAlumno)
                 getDetalleMateria(ids){
                     it.fold(::handleFailure){
                        state.value= DetalleViewState.detalleRecieved(it)
                         true
                     }
                 }
            }
        }
    }

    private fun notFound(failure: Failure){
        state.value= DetalleViewState.NotFound
        handleFailure(failure = failure)
    }
}