package com.example.profesoresapp.presentation.Detalle


import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.usecase.GetAlumnosPorMateria
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class DetalleViewModel @Inject constructor(
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