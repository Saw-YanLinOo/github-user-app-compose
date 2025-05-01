package com.agb.github_user_app.di

import com.agb.github_user_app.data.repository.GithubRepository
import com.agb.github_user_app.data.repository.GithubRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

//    @Provides
//    @Singleton
//    fun provideGithubRepository(githubApi: GithubApi): GithubRepository {
//        return GithubRepositoryImpl(githubApi)
//    }

    @Binds
    abstract fun provideGithubRepository(
        movieDataSourceImpl: GithubRepositoryImpl
    ): GithubRepository
}