package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.repository.AlumnoRepository
import javax.inject.Inject

class SaveAlumnos @Inject constructor(private val alumnoRepository: AlumnoRepository) :
    UseCase<Boolean, List<Alumno>>() {

    override suspend fun run(params: List<Alumno>) = alumnoRepository.saveAlumno(params)
}