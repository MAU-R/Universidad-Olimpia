package com.example.alumnosapp.presentation.alumno

import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.usecase.GetAlumnosByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class AlumnoViewModel @Inject constructor(private val getAlumnosByName: GetAlumnosByName) :
    BaseViewModel() {

    fun doGetAlumnosByName(name: String) {
        getAlumnosByName(name) {
            it.fold(::handleFailure) {
                state.value = AlumnoViewState.AlumnosReceived(it.alumnos ?: listOf())

                true
            }
        }
    }

}