package com.example.alumnosapp.domain.usecase


import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.domain.model.Alumno
import com.example.alumnosapp.domain.repository.AlumnoRepository
import javax.inject.Inject

class doLogin @Inject constructor(private val alumnoRepository: AlumnoRepository): UseCase<Alumno, Alumno>(){
    override suspend fun run(params: Alumno)= alumnoRepository.login(params)
}