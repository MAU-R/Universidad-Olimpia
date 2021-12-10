package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.Materia
import com.example.alumnosapp.domain.model.TwoIds
import com.example.alumnosapp.domain.repository.DetalleRepository
import javax.inject.Inject

class GetDetalleMateria @Inject constructor(private val DetalleRepository: DetalleRepository):
    UseCase<DetallesMateria, TwoIds>(){

    override suspend fun run(params: TwoIds): Either<Failure, DetallesMateria> {
        return DetalleRepository.getDetalleMateria(params)
    }
}