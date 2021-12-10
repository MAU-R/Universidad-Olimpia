package com.example.alumnosapp.presentation.detalle

import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.domain.model.DetallesMateria

sealed class DetalleViewState : BaseViewState(){

    data class detalleRecieved(val detalle: DetallesMateria): BaseViewState()
    object NotFound : BaseViewState()
}