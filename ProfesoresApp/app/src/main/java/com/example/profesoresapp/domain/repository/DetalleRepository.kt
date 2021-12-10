package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.AlumnosResponse
import com.example.profesoresapp.data.dto.MateriasResponse
import com.example.profesoresapp.domain.model.Alumno
import com.example.profesoresapp.domain.model.DetallesMateria
import com.example.profesoresapp.domain.model.Materia
import com.example.profesoresapp.domain.model.TwoIds

interface DetalleRepository {
    fun getMateriasPorProfesor(Id: Int):Either<Failure, List<Materia>>
    fun getAlumnosPorMateria(id:String):Either<Failure,List<Alumno>>
    fun getDetalleMateria(ids:TwoIds):Either<Failure, DetallesMateria>
    fun editDetalleMateria(detalle:DetallesMateria):Either<Failure, DetallesMateria>
}