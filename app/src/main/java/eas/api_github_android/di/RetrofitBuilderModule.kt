package eas.api_github_android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import eas.api_github_android.network.RetrofitBuilder

@Module
@InstallIn(SingletonComponent::class)
object RetrofitBuilderModule {

    @Provides
    fun provideRetrofitBuilder(): RetrofitBuilder {
        return RetrofitBuilder()
    }
}