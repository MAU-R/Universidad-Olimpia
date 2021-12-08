package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.dao.AlumnoDao
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class AlumnoRepositoryImpl @Inject constructor(
    private val alumnoApi: AlumnoApi,
    private val networkHandler: NetworkHandler,
    private val alumnoDao: AlumnoDao
) :
    AlumnoRepository, ApiRequest {

    override fun getAlumnosByName(name: String) : Either<Failure, AlumnosResponse> {
        val result = makeRequest(networkHandler, alumnoApi.getAlumnosByName(name), { it }, AlumnosResponse(emptyList()))

        return if (result.isLeft) {

            val localResult = alumnoDao.getAlumnosByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(AlumnosResponse(localResult))

        } else result

    }

    override fun saveAlumno(alumnos: List<Alumno>): Either<Failure, Boolean> {
        val result = alumnoDao.saveAlumnos(alumnos)
        return if (result.size == alumnos.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateAlumno(alumno: Alumno): Either<Failure, Boolean> {
        TODO("Not yet implemented")
    }
}