package com.manarimjesse.githubprofiles.di

import com.manarimjesse.githubprofiles.data.user_detail.remote.UserDetailServiceImpl
import com.manarimjesse.githubprofiles.data.user_detail.repository.UserDetailRepositoryImpl
import com.manarimjesse.githubprofiles.domain.user_list.remote.UserListService
import com.manarimjesse.githubprofiles.domain.user_list.repository.UserListRepository
import com.manarimjesse.githubprofiles.data.user_list.remote.UserListServiceImpl
import com.manarimjesse.githubprofiles.data.user_list.repository.UserListRepositoryImpl
import com.manarimjesse.githubprofiles.domain.user_detail.remote.UserDetailService
import com.manarimjesse.githubprofiles.domain.user_detail.repository.UserDetailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserListService(client: HttpClient): UserListService {
        return UserListServiceImpl(client)
    }

    @Singleton
    @Provides
    fun provideUserDetailService(client: HttpClient): UserDetailService {
        return UserDetailServiceImpl(client)
    }

    @Singleton
    @Provides
    fun provideGitHubRepository(apiService: UserListService): UserListRepository {
        return UserListRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun provideUserDetailRepository(apiService: UserDetailService): UserDetailRepository {
        return UserDetailRepositoryImpl(apiService)
    }
}