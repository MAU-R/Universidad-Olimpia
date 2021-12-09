package com.example.alumnosapp.presentation.login

import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.domain.model.Alumno

sealed class LoginViewState : BaseViewState() {

    data class LoggedUser(val alumno: Alumno): BaseViewState()

}