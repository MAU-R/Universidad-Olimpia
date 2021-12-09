package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.domain.repository.DetalleRepository
import javax.inject.Inject

class GetAlumnosPorMateria @Inject constructor(private val DetalleRepository: DetalleRepository):
    UseCase<List<Alumno>, String>(){

    override suspend fun run(params: String): Either<Failure, List<Alumno>> {
        return DetalleRepository.getAlumnosPorMateria(params)
    }
}