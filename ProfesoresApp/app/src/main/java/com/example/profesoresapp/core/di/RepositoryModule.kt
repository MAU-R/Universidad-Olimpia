package com.example.profesoresapp.core.di


import com.example.profesoresapp.core.plataform.NetworkHandler
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
    fun provideCategoryRepository(
        apiProvider: ApiProvider,
        schoolDb: SchoolDb,
        networkHandler: NetworkHandler
    ): AlumnosRepository =
        AlumnosRepositoryImpl(
            apiProvider.getEndpoint(SchoolApi::class.java),
            SchoolDb.AlumnosDao(),
            networkHandler
        )

    @Provides
    @Singleton
    fun provideMealRepository(
        apiProvider: ApiProvider,
        schoolDb: SchoolDb,
        networkHandler: NetworkHandler
    ): AlumnosRepository =
        AlumnosRepositoryImpl(
            apiProvider.getEndpoint(SchoolApi::class.java),
            SchoolDb.AlumnosDao(),
            networkHandler
        )

    @Provides
    @Singleton
    fun provideUserRepository(authManager: AuthManager, schoolDb: SchoolDb): UserRepository =
        UserRepositoryImpl(authManager, schoolDb: SchoolDb())

}