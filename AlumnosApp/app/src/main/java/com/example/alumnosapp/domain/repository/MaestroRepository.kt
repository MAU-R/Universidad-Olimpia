package com.example.alumnosapp.domain.repository

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.Maestro


interface MaestroRepository {

    fun getMaestroById(id:Int): Either<Failure, Maestro>

}