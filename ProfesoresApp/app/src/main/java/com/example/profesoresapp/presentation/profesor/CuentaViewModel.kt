package com.example.profesoresapp.presentation.profesor

import androidx.lifecycle.ViewModel
import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.usecase.CerrarSesion
import com.example.profesoresapp.domain.usecase.getLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject


@DelicateCoroutinesApi
@HiltViewModel
class CuentaViewModel   @Inject constructor(
    private val getLocalUser: getLocalUser,
    private val cerrarSesion: CerrarSesion
) :
BaseViewModel() {

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
}