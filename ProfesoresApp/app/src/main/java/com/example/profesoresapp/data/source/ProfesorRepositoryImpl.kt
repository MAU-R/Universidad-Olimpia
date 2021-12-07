package com.example.profesoresapp.data.source

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.ProfesorApi
import com.example.profesoresapp.data.dao.ProfesorDao
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.repository.ProfesorRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class ProfesorRepositoryImpl @Inject constructor(
    private val profesorApi: ProfesorApi,
    private val networkHandler: NetworkHandler,
    private val profesorDao: ProfesorDao
) :
    ProfesorRepository, ApiRequest {

    override fun getProfesoresByName(name: String) : Either<Failure, ProfesoresResponse> {
        val result = makeRequest(networkHandler, profesorApi.getProfesoresByName(name), { it }, ProfesoresResponse(emptyList()))

        return if (result.isLeft) {

            val localResult = profesorDao.getProfesoresByName("%$name%")

            if (localResult.isEmpty()) result
            else Either.Right(ProfesoresResponse(localResult))

        } else result

    }

    override fun saveProfesor(profesores: List<Profesor>): Either<Failure, Boolean> {
        val result = profesorDao.saveProfesores(profesores)
        return if (result.size == profesores.size) Either.Right(true)
        else Either.Left(Failure.DatabaseError)
    }

    override fun updateProfesor(profesor: Profesor): Either<Failure, Boolean> {
        TODO("Not yet implemented")
    }
}