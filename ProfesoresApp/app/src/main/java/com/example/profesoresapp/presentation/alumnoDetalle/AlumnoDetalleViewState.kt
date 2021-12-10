package com.example.profesoresapp.presentation.alumnoDetalle

import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Profesor

sealed class AlumnoDetalleViewState: BaseViewState() {

    data class detalleRecieved(val detalle: DetallesMateria): BaseViewState()
    object NotFound : BaseViewState()
}