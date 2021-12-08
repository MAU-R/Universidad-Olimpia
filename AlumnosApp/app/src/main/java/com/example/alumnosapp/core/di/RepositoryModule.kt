package com.example.alumnosapp.core.di

import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.source.AlumnoRepositoryImpl
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.framework.api.ApiProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideAlumnoRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): AlumnoRepository =
        AlumnoRepositoryImpl(apiProvider.getEndpoint(AlumnoApi::class.java), networkHandler)
}