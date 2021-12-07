package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.repository.ProfesorRepository
import javax.inject.Inject

class SaveProfesores @Inject constructor(private val profesorRepository: ProfesorRepository) :
    UseCase<Boolean, List<Profesor>>() {

    override suspend fun run(params: List<Profesor>) = profesorRepository.saveProfesor(params)
}