package com.example.profesoresapp.core.di


import com.example.profesoresapp.core.plataform.NetworkHandler
import com.example.profesoresapp.data.api.ProfesorApi
import com.example.profesoresapp.data.source.ProfesorRepositoryImpl
import com.example.profesoresapp.domain.repository.ProfesorRepository
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
    ): ProfesorRepository =
        ProfesorRepositoryImpl(apiProvider.getEndpoint(ProfesorApi::class.java), networkHandler)
}