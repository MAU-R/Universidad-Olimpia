package com.example.alumnosapp.domain.repository

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.data.dto.AlumnosResponse
import com.example.alumnosapp.data.dto.MateriasResponse
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.model.DetallesMateria
import com.example.alumnosapp.domain.model.Materia

interface DetalleRepository {
    fun getMateriasPorAlumno(Id: Int):Either<Failure, List<Materia>>
    fun getDetalleMateria(id:Int, ida:Int):Either<Failure, DetallesMateria>
}