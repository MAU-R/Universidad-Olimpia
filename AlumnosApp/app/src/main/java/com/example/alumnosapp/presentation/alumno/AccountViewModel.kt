package com.example.alumnosapp.presentation.alumno

import androidx.lifecycle.ViewModel
import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.usecase.CerrarSesion
import com.example.alumnosapp.domain.usecase.getLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getLocalUser: getLocalUser,
    private val cerrarSesion: CerrarSesion
) :
    BaseViewModel() {

    fun logout(){
        cerrarSesion(UseCase.None()){
            it.fold(::userNotFound){

            }
            state.value=AccountViewState.UserNotFound
        }
    }
    fun getLocalUser(){
        getLocalUser(UseCase.None()){
            it.fold(::userNotFound){
                state.value=AccountViewState.LoggedUser(it)
                true
            }
        }
    }
    private fun userNotFound(failure: Failure){
        state.value=AccountViewState.UserNotFound
        handleFailure(failure = failure)
    }
}