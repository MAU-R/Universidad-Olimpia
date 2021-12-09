package com.example.profesoresapp.domain.repository

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.data.dto.ProfesoresResponse
import com.example.profesoresapp.domain.model.Profesor


interface MaestroRepository {
fun login(profesor: Profesor):Either<Failure, Profesor>
fun updateProfile(profesor: Profesor):Either<Failure,Profesor>
fun getUser(usuario: Profesor):Either<Failure, Profesor>
}