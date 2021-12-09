package com.example.profesoresapp.core.di
import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.AlumnoApi
import com.example.profesoresapp.data.api.DetalleApi
import com.example.profesoresapp.data.api.MaestroApi
import com.example.profesoresapp.data.api.MateriaApi
import com.example.profesoresapp.data.source.AlumnoRepositoryImpl
import com.example.profesoresapp.data.source.DetalleRepositoryImpl
import com.example.profesoresapp.data.source.MaestroRepositoryImpl
import com.example.profesoresapp.data.source.MateriaRepositoryImpl
import com.example.profesoresapp.domain.repository.AlumnoRepository
import com.example.profesoresapp.domain.repository.DetalleRepository
import com.example.profesoresapp.domain.repository.MaestroRepository
import com.example.profesoresapp.domain.repository.MateriaRepository
import com.example.profesoresapp.framework.api.ApiProvider
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
    fun provideProfesorRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): MaestroRepository =
        MaestroRepositoryImpl(apiProvider.getEndpoint(MaestroApi::class.java), networkHandler)

    @Provides
    @Singleton
    fun provideDetalleRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): DetalleRepository =
        DetalleRepositoryImpl(apiProvider.getEndpoint(DetalleApi::class.java), networkHandler)

    @Provides
    @Singleton
    fun provideAlumnoRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): AlumnoRepository =
        AlumnoRepositoryImpl(apiProvider.getEndpoint(AlumnoApi::class.java), networkHandler)

    @Provides
    @Singleton
    fun provideMaestroRepository(
        apiProvider: ApiProvider,
        networkHandler: NetworkHandler
    ): MateriaRepository =
        MateriaRepositoryImpl(apiProvider.getEndpoint(MateriaApi::class.java), networkHandler)

}