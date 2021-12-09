package com.example.alumnosapp.data.source

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.api.MaestroApi
import com.example.alumnosapp.data.api.MateriaApi
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MaestrosResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.Maestro
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.domain.repository.MaestroRepository
import com.example.alumnosapp.domain.repository.MateriaRepository
import com.example.alumnosapp.framework.api.ApiRequest
import javax.inject.Inject

class MateriaRepositoryImpl @Inject constructor(
    private val materiaApi: MateriaApi,
    private val networkHandler: NetworkHandler
) :
    MateriaRepository, ApiRequest {
    override fun getMateriaById(id: Int): Either<Failure, Materia> {
        val result = makeRequest(
            networkHandler, materiaApi.getMateriaById(id),{
                it.materias?.get(0)?: Materia()
            },
            MateriasResponse(
                emptyList()
            )
        )
        return result
    }


    //Esta es solo para el use case
    override fun getMateriasByName(name: String) = makeRequest(
        networkHandler, materiaApi.getMateriasByName(name), { it }, MateriasResponse(
            emptyList()
        )
    )
}