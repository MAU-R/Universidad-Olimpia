package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.model.Profesor


interface ProfesorRepository {

    fun getProfesoresByName(name: String): Either<Failure, ProfesoresResponse>

    fun saveProfesor(alumnos: List<Profesor>): Either<Failure, Boolean>

    fun updateProfesor(alumno: Profesor): Either<Failure, Boolean>

}