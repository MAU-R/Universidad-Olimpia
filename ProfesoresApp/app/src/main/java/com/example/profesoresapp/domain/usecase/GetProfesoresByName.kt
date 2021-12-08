package com.example.profesoresapp.domain.usecase


import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.repository.ProfesorRepository
import javax.inject.Inject

class GetProfesoresByName @Inject constructor(private val profesorRepository: ProfesorRepository) :
    UseCase<ProfesoresResponse, String>() {

    override suspend fun run(params: String) = profesorRepository.getProfesoresByName(params)

}