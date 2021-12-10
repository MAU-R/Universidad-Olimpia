package com.example.profesoresapp.presentation.Detalle

import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Profesor

sealed class MateriaDetailViewState : BaseViewState() {

    data class alumnosReceived(val alumnos: List<Alumno>): BaseViewState()
    data class  detalleRecieved(val detalle:DetallesMateria):BaseViewState()
}