package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.DetalleApi
import com.example.alumnosapp.data.dto.DetalleResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.domain.model.TwoIds
import com.example.alumnosapp.domain.repository.DetalleRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class DetalleRepositoryImpl @Inject constructor(
    private val detalleApi: DetalleApi,
    private val networkHandler: NetworkHandler
) :
    DetalleRepository, ApiRequest {
    override fun getMateriasPorAlumno(Id: Int): Either<Failure, List<Materia>> {
        val result = makeRequest(
            networkHandler, detalleApi.getMateriasPorAlumno(Id),
            {it},
            emptyList<Materia>()
        )
        return result
    }

    override fun getDetalleMateria(ids: TwoIds): Either<Failure, DetallesMateria> {
        val result = makeRequest(
            networkHandler, detalleApi.getDetalleMateria(ids),{it},
            DetallesMateria()
        )
        return result
    }


}