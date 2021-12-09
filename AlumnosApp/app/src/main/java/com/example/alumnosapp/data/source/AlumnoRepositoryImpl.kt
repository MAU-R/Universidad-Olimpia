package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class AlumnoRepositoryImpl @Inject constructor(
    private val alumnoApi: AlumnoApi,
    private val networkHandler: NetworkHandler
) :
    AlumnoRepository, ApiRequest {
    override fun login(alumno: Alumno): Either<Failure, Alumno> {
        val result = makeRequest(
            networkHandler,alumnoApi.login(alumno),
            {
                it
            },
            Alumno()
        )
        return result
    }

    override fun updateProfile(alumno: Alumno): Either<Failure, Alumno> {
        val result= makeRequest(
            networkHandler,alumnoApi.updateAlumno(alumno),{
                it.alumnos?.get(0)?:Alumno()
            },
            AlumnosResponse(emptyList())
        )
        return result
    }

    override fun getUser(usuario: Alumno): Either<Failure, Alumno> {
        TODO("Not yet implemented")
    }
}