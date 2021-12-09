package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.domain.model.Alumno

interface AlumnoRepository {

    fun getAlumnoById(id:Int): Either<Failure, Alumno>

}