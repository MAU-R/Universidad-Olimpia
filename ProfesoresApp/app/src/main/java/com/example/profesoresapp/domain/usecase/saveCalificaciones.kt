package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.TwoIds
import com.example.profesoresapp.domain.repository.DetalleRepository
import javax.inject.Inject

class saveCalificaciones @Inject constructor(private val detalleRepository: DetalleRepository) :
    UseCase<DetallesMateria, DetallesMateria>() {
    override suspend fun run(params: DetallesMateria) = detalleRepository.editDetalleMateria(params)

}