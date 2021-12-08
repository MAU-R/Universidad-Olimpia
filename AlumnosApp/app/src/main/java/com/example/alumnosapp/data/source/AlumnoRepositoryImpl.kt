package com.example.alumnosapp.data.source

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

    override fun getAlumnosByName(name: String) = makeRequest(
        networkHandler, alumnoApi.getAlumnosByName(name), { it }, AlumnosResponse(
            emptyList()
        )
    )
}