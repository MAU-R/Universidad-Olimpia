package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.TwoIds
import com.example.profesoresapp.domain.repository.DetalleRepository
import com.example.profesoresapp.domain.repository.MateriaRepository
import javax.inject.Inject

class getDetalleMateria @Inject constructor(private val detalleRepository: DetalleRepository) :
    UseCase<DetallesMateria, TwoIds>() {
    override suspend fun run(params: TwoIds) = detalleRepository.getDetalleMateria(params)

}