package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Materia

interface DetalleRepository {
    fun getMateriasPorProfesor(Id: Int):Either<Failure, MateriasResponse>
    fun getAlumnosPorMateria(id:Int):Either<Failure,AlumnosResponse>
    fun getDetalleMateria(id:Int, ida:Int):Either<Failure, DetallesMateria>
}