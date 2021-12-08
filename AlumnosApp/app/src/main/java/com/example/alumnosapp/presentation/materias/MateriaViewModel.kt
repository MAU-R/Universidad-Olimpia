package com.example.alumnosapp.presentation.materias

import com.example.alumnosapp.core.presentation.BaseViewModel
import com.example.alumnosapp.domain.usecase.GetMateriasByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject

@DelicateCoroutinesApi
@HiltViewModel
class MateriaViewModel @Inject constructor(private val getMateriasByName: GetMateriasByName) :
    BaseViewModel() {

    fun doGetMateriasByName(name: String) {
        getMateriasByName(name) {
            it.fold(::handleFailure) {
                state.value = MateriaViewState.MateriasReceived(it.materias ?: listOf())

                true
            }
        }
    }

}