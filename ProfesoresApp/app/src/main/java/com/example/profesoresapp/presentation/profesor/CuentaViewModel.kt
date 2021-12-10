package com.example.profesoresapp.presentation.profesor

import androidx.lifecycle.ViewModel
import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.usecase.CerrarSesion
import com.example.profesoresapp.domain.usecase.SaveLocalUser
import com.example.profesoresapp.domain.usecase.getLocalUser
import com.example.profesoresapp.domain.usecase.saveProfesor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


@DelicateCoroutinesApi
@HiltViewModel
class CuentaViewModel   @Inject constructor(
    private val getLocalUser: getLocalUser,
    private val cerrarSesion: CerrarSesion,
    private val saveProfesor: saveProfesor,
    private val saveLocalUser: SaveLocalUser
) :
BaseViewModel() {
fun doSaveLocalUser(profesor: Profesor){
    saveLocalUser(profesor){
        it.fold(::handleFailure){

            true
        }
    }
}
fun logout(){
    cerrarSesion(UseCase.None()){
        it.fold(::userNotFound){

        }
        state.value=CuentaViewState.UserNotFound
    }
}
    fun getLocalUser(){
    getLocalUser(UseCase.None()){
        it.fold(::userNotFound){
            state.value=CuentaViewState.LoggedUser(it)
            true
        }
    }
    }
   private fun userNotFound(failure: Failure){
        state.value=CuentaViewState.UserNotFound
        handleFailure(failure = failure)
    }

    fun guardar(profesor:Profesor){
        saveProfesor(profesor){
            it.fold(::handleFailure){
                true
            }
        }
    }
}