package eas.api_github_android.domain.usecase.repositories

import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.data.repository.GitHubRepository
import eas.api_github_android.domain.mapper.RepositoriesMapper
import eas.api_github_android.network.statushandler.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext
import javax.inject.Inject

interface RepositoriesUseCase {
    suspend operator fun invoke(): Resource<RepositoriesResponse>
}

class RepositoriesUseCaseImpl @Inject constructor(
    private val repository: GitHubRepository
) : RepositoriesUseCase {
    override suspend fun invoke() = withContext(IO) {
        repository.getRepositories()
    }
}