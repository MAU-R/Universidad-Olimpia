package com.example.profesoresapp.domain.usecase


import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.repository.MateriaRepository
import javax.inject.Inject

class GetMateriasByName @Inject constructor(private val materiaRepository: MateriaRepository) :
    UseCase<MateriasResponse, String>() {

    override suspend fun run(params: String) = materiaRepository.getMateriasByName(params)

}