package com.example.profesoresapp.presentation.materias


import com.example.profesoresapp.core.presentation.BaseViewState
import com.example.profesoresapp.domain.model.Materia

sealed class MateriaViewState: BaseViewState() {

    data class MateriasReceived(val materias: List<Materia>): BaseViewState()

}