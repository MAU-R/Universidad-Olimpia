package com.example.alumnosapp.domain.usecase

import com.example.alumnosapp.core.exception.Failure
import com.example.alumnosapp.core.functional.Either
import com.example.alumnosapp.core.interactor.UseCase
import com.example.alumnosapp.core.plataform.AuthManager
import com.example.alumnosapp.domain.model.Alumno
import javax.inject.Inject

class SaveLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<Alumno, Alumno>() {

    override suspend fun run(params: Alumno): Either<Failure, Alumno> {
        val result = authManager.usuario
        if (result==null)authManager.usuario=params
        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }
}