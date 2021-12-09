package com.example.profesoresapp.presentation.profesor

import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.domain.model.Profesor

sealed class CuentaViewState : BaseViewState() {

    data class LoggedUser(val profesor: Profesor): BaseViewState()
    object UserNotFound : BaseViewState()
}