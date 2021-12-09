package com.example.profesoresapp.data.source

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.DetalleApi
import com.example.profesoresapp.data.api.MateriaApi
import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.data.dto.DetalleResponse
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.domain.repository.DetalleRepository
import com.example.profesoresapp.domain.repository.MateriaRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class DetalleRepositoryImpl @Inject constructor(
    private val detalleApi: DetalleApi,
    private val networkHandler: NetworkHandler
) :
    DetalleRepository, ApiRequest {
    override fun getMateriasPorProfesor(Id: Int): Either<Failure, List<Materia>> {
       val result = makeRequest(
           networkHandler, detalleApi.getMateriasPorProfesor(Id),
           {it},
           emptyList<Materia>()
       )
        return result
    }

    override fun getAlumnosPorMateria(id: String): Either<Failure, List<Alumno>> {
       val result = makeRequest(
           networkHandler, detalleApi.getAlumnosPorMateria(id),{it}, listOf())

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