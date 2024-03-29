package com.example.profesoresapp.presentation.login

import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.usecase.GetMateriasByName
import com.example.profesoresapp.domain.usecase.SaveLocalUser
import com.example.profesoresapp.domain.usecase.doLogin
import com.example.profesoresapp.presentation.materias.MateriaViewState
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val dologin: doLogin,
    private  val saveLocalUser: SaveLocalUser
    ) : BaseViewModel() {

    fun doLogin(matricula:Int, contrasena:String){
        dologin(Profesor(idProfesor = matricula?:0, contrasena=contrasena?:"")){
            it.fold(::handleFailure){
                it.name
                it.foto
                state.value=LoginViewState.LoggedUser(it)
                true
                saveLocalUser(it)
            }
        }
    }

fun saveLocalUser(profesor:Profesor){
    saveLocalUser(profesor){
        it.fold(::handleFailure){

        }
    }
}
}