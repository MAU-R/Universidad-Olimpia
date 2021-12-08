package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.MateriasResponse


interface MateriaRepository {

    fun getMateriasByName(name: String): Either<Failure, MateriasResponse>

}