package eas.api_github_android.data.repository

import androidx.annotation.WorkerThread
import dagger.hilt.android.scopes.ViewModelScoped
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.extension.networkCall
import eas.api_github_android.network.RetrofitBuilder
import eas.api_github_android.network.statushandler.Resource
import javax.inject.Inject

@ViewModelScoped
class GitHubRepository @Inject constructor(
    private val builder: RetrofitBuilder
) {

    @WorkerThread
    suspend fun getRepositories(): Resource<RepositoriesResponse> = builder.networkCall {
        builder.build().getRepositories()
    }
}