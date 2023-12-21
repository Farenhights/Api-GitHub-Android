package eas.api_github_android.di

import eas.api_github_android.data.repository.GitHubRepository
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCase
import eas.api_github_android.domain.usecase.repositories.RepositoriesUseCaseImpl
import eas.api_github_android.network.RetrofitBuilder
import eas.api_github_android.presentation.ui.viewmodel.RepositoriesViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    factory { RetrofitBuilder(androidContext()) }
}

val moduleRepository = module {
    factory { GitHubRepository }
}

val viewModelModule = module {
    viewModel { RepositoriesViewModel(get()) }
//    viewModel { PullRequestsViewModel( get() ) }*/
}

val useCaseModule = module {
    factory<RepositoriesUseCase> { RepositoriesUseCaseImpl(get()) }
}