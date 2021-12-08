package com.example.profesoresapp.data.source


import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.ProfesorApi
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.repository.ProfesorRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class ProfesorRepositoryImpl @Inject constructor(
    private val profesorApi: ProfesorApi,
    private val networkHandler: NetworkHandler
) :
    ProfesorRepository, ApiRequest {

    override fun getProfesoresByName(name: String) = makeRequest(
        networkHandler, profesorApi.getProfesoresByName(name), { it }, ProfesoresResponse(
            emptyList()
        )
    )
}