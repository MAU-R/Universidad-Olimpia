package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.domain.model.Profesor
import com.example.profesoresapp.domain.repository.MaestroRepository
import javax.inject.Inject

class saveProfesor @Inject constructor(private val maestroRepository: MaestroRepository): UseCase<Profesor, Profesor>(){
    override suspend fun run(params: Profesor)= maestroRepository.updateProfile(params)
}