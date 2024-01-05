package eas.api_github_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eas.api_github_android.data.repository.GitHubRepository
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCaseImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideRepositoriesUseCase(repository: GitHubRepository): RepositoriesUseCase {
        return RepositoriesUseCaseImpl(repository)
    }
}