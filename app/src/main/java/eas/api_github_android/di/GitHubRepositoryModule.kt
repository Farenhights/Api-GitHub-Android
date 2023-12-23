package eas.api_github_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eas.api_github_android.data.repository.GitHubRepository
import eas.api_github_android.network.RetrofitBuilder

@Module
@InstallIn(SingletonComponent::class)
object GitHubRepositoryModule {

    @Provides
    fun provideGitHubRepository(builder: RetrofitBuilder): GitHubRepository {
        return GitHubRepository(builder)
    }
}