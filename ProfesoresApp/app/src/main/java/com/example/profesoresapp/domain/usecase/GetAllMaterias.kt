package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.domain.repository.DetalleRepository
import javax.inject.Inject

class GetAllMaterias @Inject constructor(private val DetalleRepository: DetalleRepository):
    UseCase<List<Materia>, Int>(){

    override suspend fun run(params: Int): Either<Failure, List<Materia>> {
        return DetalleRepository.getMateriasPorProfesor(params)
    }
}