package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.plataform.AuthManager
import com.example.alumnosapp.domain.model.Alumno
import javax.inject.Inject

class getLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<Alumno, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, Alumno> {
        val result = authManager.usuario
        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }
}