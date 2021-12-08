package com.example.alumnosapp.presentation.materias

import com.example.alumnosapp.core.presentation.BaseViewState
import com.example.alumnosapp.domain.model.Materia

sealed class MateriaViewState: BaseViewState() {

    data class MateriasReceived(val materias: List<Materia>): BaseViewState()

}