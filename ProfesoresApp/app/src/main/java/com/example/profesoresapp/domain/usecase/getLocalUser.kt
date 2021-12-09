package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.core.plataform.AuthManager
import com.example.profesoresapp.domain.model.Profesor
import javax.inject.Inject

class getLocalUser @Inject constructor(private val authManager: AuthManager) :
    UseCase<Profesor, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, Profesor> {
        val result = authManager.usuario
        return result?.let {
            Either.Right(it)
        } ?: Either.Left(Failure.Unauthorized)
    }
}