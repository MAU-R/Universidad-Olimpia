package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.domain.repository.DetalleRepository
import javax.inject.Inject

class GetAllMaterias @Inject constructor(private val DetalleRepository: DetalleRepository):
    UseCase<List<Materia>, Int>(){

    override suspend fun run(params: Int): Either<Failure, List<Materia>> {
        return DetalleRepository.getMateriasPorAlumno(params)
    }
}