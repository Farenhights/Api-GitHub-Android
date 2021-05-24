package eas.api_github_android.data.api

import eas.api_github_android.data.model.pullrequests.response.PullRequestsResponse
import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.network.result.Result
import eas.api_github_android.network.result.ResultError
import eas.api_github_android.network.statushandler.ErrorStatus
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.Response

interface GitHubApi {

    @GET("search/repositories?q=language:Java&sort=stars&page=1")
    suspend fun getRepositories(): Deferred<Response<RepositoriesResponse>>

    @GET("repos/{criador}/{repositorio}/pulls")
    suspend fun getPullRequests(
        @Path("criador") creator: String,
        @Path("repositorio") repository: String
    ): Deferred<Response<List<PullRequestsResponse>>>
}