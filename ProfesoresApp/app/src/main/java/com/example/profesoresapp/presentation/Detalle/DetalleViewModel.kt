package com.example.profesoresapp.presentation.Detalle


import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.core.presentation.BaseViewModel
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.TwoIds
import com.example.profesoresapp.domain.usecase.GetAlumnosPorMateria
import com.example.profesoresapp.domain.usecase.getDetalleMateria
import com.example.profesoresapp.domain.usecase.getLocalUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.DelicateCoroutinesApi
import javax.inject.Inject
@DelicateCoroutinesApi
@HiltViewModel
class DetalleViewModel @Inject constructor(
    private val getAlumnosPorMateria: GetAlumnosPorMateria,
    private val getDetalleMateria: getDetalleMateria,
    private val getLocalUser: getLocalUser
) : BaseViewModel() {

    fun doGetAlumnosPorMateria(id:String){
        getAlumnosPorMateria(id){
            it.fold(::handleFailure){
                state.value = MateriaDetailViewState.alumnosReceived(it ?: listOf())
                true
            }
        }
    }

    fun doGetDetalleMateria(id:Int){
      getLocalUser(UseCase.None()){
          it.fold(::handleFailure){
              val ids= TwoIds(id,it.idProfesor?:0)
              getDetalleMateria(ids){
                  it.fold(::handleFailure){
                      doGetAlumnosPorMateria(it.matricula)
                  }
              }
          }
      }
    }
}