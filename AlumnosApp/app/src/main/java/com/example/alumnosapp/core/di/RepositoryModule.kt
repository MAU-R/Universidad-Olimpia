package com.example.alumnosapp.core.di

import com.example.alumnosapp.core.plataform.NetworkHandler
import com.example.alumnosapp.data.api.AlumnoApi
import com.example.alumnosapp.data.api.DetalleApi
import com.example.alumnosapp.data.api.MaestroApi
import com.example.alumnosapp.data.api.MateriaApi
import com.example.alumnosapp.data.source.AlumnoRepositoryImpl
import com.example.alumnosapp.data.source.DetalleRepositoryImpl
import com.example.alumnosapp.data.source.MaestroRepositoryImpl
import com.example.alumnosapp.data.source.MateriaRepositoryImpl
import com.example.alumnosapp.domain.repository.AlumnoRepository
import com.example.alumnosapp.domain.repository.DetalleRepository
import com.example.alumnosapp.domain.repository.MaestroRepository
import com.example.alumnosapp.domain.repository.MateriaRepository
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

    @Provides
    @Singleton
    fun provideMateriaRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): MateriaRepository =
        MateriaRepositoryImpl(apiProvider.getEndpoint(MateriaApi::class.java), networkHandler)

    @Provides
    @Singleton
    fun provideMaestroRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): MaestroRepository =
        MaestroRepositoryImpl(apiProvider.getEndpoint(MaestroApi::class.java), networkHandler)

    @Provides
    @Singleton
    fun provideDetalleMRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): DetalleRepository =
        DetalleRepositoryImpl(apiProvider.getEndpoint(DetalleApi::class.java), networkHandler)
}