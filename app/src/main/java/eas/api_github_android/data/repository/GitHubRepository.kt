package eas.api_github_android.data.repository

import androidx.annotation.WorkerThread
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.extension.networkCall
import eas.api_github_android.network.statushandler.Resource

object GitHubRepository : BaseRepository() {

    @WorkerThread
    suspend fun getRepositories(): Resource<RepositoriesResponse> = builder.networkCall {
        builder.build().getRepositories()
    }

}