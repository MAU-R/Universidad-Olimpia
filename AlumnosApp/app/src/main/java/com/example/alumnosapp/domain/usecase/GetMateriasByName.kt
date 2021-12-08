package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.domain.repository.MateriaRepository
import javax.inject.Inject

class GetMateriasByName @Inject constructor(private val materiaRepository: MateriaRepository) :
    UseCase<MateriasResponse, String>() {

    override suspend fun run(params: String) = materiaRepository.getMateriasByName(params)

}