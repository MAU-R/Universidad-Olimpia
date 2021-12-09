package com.example.profesoresapp.data.source

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.AlumnoApi
import com.example.profesoresapp.data.api.MateriaApi
import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.repository.AlumnoRepository
import com.example.profesoresapp.domain.repository.MateriaRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class AlumnoRepositoryImpl @Inject constructor(
    private val alumnoApi: AlumnoApi,
    private val networkHandler: NetworkHandler
) :
    AlumnoRepository, ApiRequest {
    override fun getAlumnoById(id: Int): Either<Failure, Alumno> {
        val result = makeRequest(
            networkHandler, alumnoApi.getAlumnoById(id),{
                it.alumnos?.get(0)?: Alumno()
            },
            AlumnosResponse(
                emptyList()
            )
        )
        return result
    }
}