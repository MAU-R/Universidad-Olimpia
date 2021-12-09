package com.example.alumnosapp.presentation.materias

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.usecase.GetAllMaterias
import com.example.alumnosapp.domain.usecase.GetMateriasByName
import com.example.alumnosapp.domain.usecase.getLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel @Inject constructor(
    private val getMateriasByName: GetMateriasByName,
    private val getAllMaterias: GetAllMaterias,
    private val getlocalUser: getLocalUser
) :
    BaseViewModel() {

    fun doGetMateriasByName(name: String) {
        getMateriasByName(name) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriasReceived(it.materias ?: listOf())

                true
            }
        }
    }

    private fun makeGetAllRequest(id:Int){
        getAllMaterias(id){
            it.fold(::handleFailure){
                state.value=MateriaViewState.MateriasReceived(it ?: listOf())
                true
            }
        }
    }
    fun doGetAllMaterias()
    {
        getlocalUser(UseCase.None()){
            it.fold(::printError){
                makeGetAllRequest(it.idAlumno?:0)
            }
        }
    }
    private fun printError(failure: Failure){}
}