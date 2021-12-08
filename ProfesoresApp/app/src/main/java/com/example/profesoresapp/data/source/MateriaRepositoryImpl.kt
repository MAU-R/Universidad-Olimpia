package com.example.profesoresapp.data.source


import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.MateriaApi
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.repository.MateriaRepository
import com.example.profesoresapp.framework.api.ApiRequest
import javax.inject.Inject

class MateriaRepositoryImpl @Inject constructor(
    private val materiaApi: MateriaApi,
    private val networkHandler: NetworkHandler
) :
    MateriaRepository, ApiRequest {

    override fun getMateriasByName(name: String) = makeRequest(
        networkHandler, materiaApi.getMateriasByName(name), { it }, MateriasResponse(
            emptyList()
        )
    )
}