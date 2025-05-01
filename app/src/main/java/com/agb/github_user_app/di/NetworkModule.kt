package com.agb.github_user_app.di

import com.agb.github_user_app.data.network.GithubApi
import com.agb.github_user_app.data.network.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideGithubApi(): GithubApi {
        return RetrofitInstance.api
    }
}