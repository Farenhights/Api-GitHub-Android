package eas.api_github_android.data

import eas.api_github_android.data.model.pullrequests.response.PullRequestsResponse
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.extension.networkCall
import eas.api_github_android.network.statushandler.Resource

class GitHubRepository : BaseRepository() {
    suspend fun getRepositories(): Resource<RepositoriesResponse> = builder.networkCall {
        builder.build().getRepositories().await()
    }

    suspend fun getPullRequests(
        creator: String,
        repository: String
    ): Resource<List<PullRequestsResponse>> = builder.networkCall {
        builder.build().getPullRequests(creator, repository).await()
    }
}