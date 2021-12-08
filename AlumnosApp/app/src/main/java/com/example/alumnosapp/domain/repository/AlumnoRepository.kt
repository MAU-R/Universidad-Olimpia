package com.example.alumnosapp.domain.repository

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.model.Alumno


interface AlumnoRepository {

    fun getAlumnosByName(name: String): Either<Failure, AlumnosResponse>

}