package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.Materia


interface MateriaRepository {

    fun getMateriasByName(name: String): Either<Failure, MateriasResponse>
    fun getMateriaByID(ID: Int):Either<Failure, Materia>


}