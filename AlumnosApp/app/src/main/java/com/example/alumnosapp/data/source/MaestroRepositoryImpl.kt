package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.api.MaestroApi
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MaestrosResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.Maestro
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.domain.repository.MaestroRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class MaestroRepositoryImpl @Inject constructor(
    private val maestroApi: MaestroApi,
    private val networkHandler: NetworkHandler
) :
    MaestroRepository, ApiRequest {
    override fun getMaestroById(id: Int): Either<Failure, Maestro> {
        val result = makeRequest(
            networkHandler, maestroApi.getMaestroById(id),{
                it
            },
            Maestro()
        )
        return result
    }
}