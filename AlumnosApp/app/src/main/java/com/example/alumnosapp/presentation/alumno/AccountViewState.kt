package com.example.alumnosapp.presentation.alumno

import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.domain.model.Alumno

sealed class AccountViewState : BaseViewState() {

    data class LoggedUser(val alumno: Alumno): BaseViewState()
    object UserNotFound : BaseViewState()
}