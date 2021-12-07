package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.repository.AlumnoRepository
import javax.inject.Inject

class GetAlumnosByName @Inject constructor(private val alumnoRepository: AlumnoRepository) :
    UseCase<AlumnosResponse, String>() {

    override suspend fun run(params: String) = alumnoRepository.getAlumnosByName(params)

}