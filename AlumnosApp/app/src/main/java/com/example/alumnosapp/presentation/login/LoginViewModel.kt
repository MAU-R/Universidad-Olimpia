package com.example.alumnosapp.presentation.login

import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.usecase.doLogin
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(private val dologin: doLogin) :
    BaseViewModel() {

    fun doLogin(matricula:Int, contrasena:String){
        dologin(Alumno(idAlumno = matricula?:0, password=contrasena?:"")){
            it.fold(::handleFailure){
                state.value=LoginViewState.LoggedUser(it)
                true
            }
        }
    }


}