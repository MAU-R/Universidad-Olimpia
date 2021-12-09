package com.example.profesoresapp.presentation.detalleMateria

import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.usecase.GetAllMaterias
import com.example.profesoresapp.domain.usecase.GetAlumnosPorMateria
import com.example.profesoresapp.domain.usecase.GetMateriasByName
import com.example.profesoresapp.domain.usecase.getLocalUser
import com.example.profesoresapp.presentation.materias.MateriaViewState
import javax.inject.Inject

class MateriaDetailViewModel @Inject constructor(
    private val getAlumnosPorMateria: GetAlumnosPorMateria
) : BaseViewModel() {

    fun doGetAlumnosPorMateria(id:String){
        getAlumnosPorMateria(id){
            it.fold(::handleFailure){
                state.value = MateriaDetailViewState.alumnosReceived(it ?: listOf())
                true
            }
        }
    }
}