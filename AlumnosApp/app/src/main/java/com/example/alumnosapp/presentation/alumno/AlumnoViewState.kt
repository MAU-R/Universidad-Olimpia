package com.example.alumnosapp.presentation.alumno

import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.domain.model.Alumno

sealed class AlumnoViewState: BaseViewState() {

    data class AlumnosReceived(val alumnos: List<Alumno>): BaseViewState()

}