package com.example.profesoresapp.domain.usecase

import com.example.profesoresapp.core.exception.Failure
import com.example.profesoresapp.core.functional.Either
import com.example.profesoresapp.core.interactor.UseCase
import com.example.profesoresapp.core.plataform.AuthManager
import com.example.profesoresapp.domain.model.Profesor
import javax.inject.Inject

class CerrarSesion @Inject constructor(private val authManager: AuthManager) :
    UseCase<Profesor, UseCase.None>() {

    override suspend fun run(params: None): Either<Failure, Profesor> {

        authManager.usuario= null
        return Either.Right(Profesor())
    }
}