package com.example.profesoresapp.presentation.login

import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.domain.model.Profesor

sealed class LoginViewState : BaseViewState() {

    data class LoggedUser(val profesor: Profesor): BaseViewState()

}