package eas.api_github_android.domain.usecase.pullrequests

import eas.api_github_android.domain.model.PullRequestsModel
import kotlinx.coroutines.Deferred

interface PullRequestsUseCase {
    suspend operator fun invoke(): Deferred<List<PullRequestsModel>>
}

/*
class PullRequestsUseCaseImpl(
    private val repository: GitHubRepository,
    private val mapper: PullRequestsMapper
) : PullRequestsUseCase {
    override suspend fun invoke(): Deferred<List<PullRequestsModel>> {
        repository
            .getPullRequests()
            .mapSuccess { pullRequestsListResponse ->
                pullRequestsListResponse.map { pullRequestsListResponse ->
                    mapper.mapFrom(pullRequestsListResponse)
                }
            }.mapError { it }
    }
    */
/*override suspend fun invoke() = withContext(Dispatchers.IO) {
        repository.getPullRequests()
            .mapSuccess { pullRequestsListResponse ->
                pullRequestsListResponse.map { pullRequestsResponse ->
                    mapper.mapFrom(pullRequestsResponse)
                }
            }.mapError { it }
    }*//*

}*/
