package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.DetalleApi
import com.example.alumnosapp.data.dto.DetalleResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.repository.DetalleRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class DetalleRepositoryImpl @Inject constructor(
    private val detalleApi: DetalleApi,
    private val networkHandler: NetworkHandler
) :
    DetalleRepository, ApiRequest {
    override fun getMateriasPorAlumno(Id: Int): Either<Failure, MateriasResponse> {
        val result = makeRequest(
            networkHandler, detalleApi.getMateriasPorAlumno(Id),{it}, MateriasResponse(
                emptyList()
            )
        )
        return result
    }

    override fun getDetalleMateria(id: Int, ida: Int): Either<Failure, DetallesMateria> {
        val result = makeRequest(
            networkHandler, detalleApi.getDetalleMateria(id, ida),{it.detalles?.get(0)?: DetallesMateria()},
            DetalleResponse(
                emptyList()
            )
        )
        return result
    }
}