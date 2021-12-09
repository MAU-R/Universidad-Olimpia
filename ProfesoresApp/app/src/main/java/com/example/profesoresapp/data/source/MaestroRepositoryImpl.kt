package com.example.profesoresapp.data.source

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.MaestroApi
import com.example.profesoresapp.data.api.MateriaApi
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.repository.MaestroRepository
import com.example.profesoresapp.domain.repository.MateriaRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class MaestroRepositoryImpl @Inject constructor(
    private val maestroApi: MaestroApi,
    private val networkHandler: NetworkHandler
) :
    MaestroRepository, ApiRequest {
    override fun login(profesor: Profesor): Either<Failure, Profesor> {
        val result = makeRequest(
            networkHandler,maestroApi.login(profesor),
            {
                it
            },
            Profesor()
        )
        return result
    }

    override fun updateProfile(profesor: Profesor): Either<Failure, Profesor> {
        val result= makeRequest(
            networkHandler,maestroApi.updateMaestro(profesor),{
                it.profesores?.get(0)?:Profesor()
            },
            ProfesoresResponse(emptyList())
        )
        return result
    }
}