package com.example.alumnosapp.presentation.alumno

import androidx.lifecycle.ViewModel
import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.usecase.CerrarSesion
import com.example.alumnosapp.domain.usecase.SaveLocalUser
import com.example.alumnosapp.domain.usecase.getLocalUser
import com.example.alumnosapp.domain.usecase.saveAlumno
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AccountViewModel @Inject constructor(
    private val getLocalUser: getLocalUser,
    private val cerrarSesion: CerrarSesion,
    private val saveAlumno: saveAlumno,
    private val saveLocalUser: SaveLocalUser
) :
    BaseViewModel() {
    fun doSaveLocalUser(a: Alumno){
        saveLocalUser(a){
            it.fold(::handleFailure){

                true
            }
        }
    }
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
    fun guardar(a:Alumno){
        saveAlumno(a){
            it.fold(::handleFailure){
                true
            }
        }
    }
}