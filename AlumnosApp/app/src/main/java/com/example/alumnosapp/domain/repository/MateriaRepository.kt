package com.example.alumnosapp.domain.repository

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.Maestro
import com.example.alumnosapp.domain.model.Materia


interface MateriaRepository {

    fun getMateriaById(id:Int): Either<Failure, Materia>


    //Esta es solo para el use case
    fun getMateriasByName(name: String): Either<Failure, MateriasResponse>

}