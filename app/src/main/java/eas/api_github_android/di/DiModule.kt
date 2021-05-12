package eas.api_github_android.di

import eas.api_github_android.data.GitHubRepository
import eas.api_github_android.network.RetrofitBuilder
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dataModule = module {
    factory { RetrofitBuilder(androidContext()) }
}

val moduleRepository = module {
    factory { GitHubRepository() }
}

val viewModelModule = module {
    /*viewModel { RepositoriesViewModel( get() ) }
    viewModel { PullRequestsViewModel( get() ) }*/
}