package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.ProfesoresResponse


interface ProfesorRepository {

    fun getProfesoresByName(name: String): Either<Failure, ProfesoresResponse>

}