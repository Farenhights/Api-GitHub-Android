package eas.api_github_android.domain.usecase.repositories

import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.data.repository.GitHubRepository
import eas.api_github_android.domain.mapper.RepositoriesMapper
import eas.api_github_android.network.statushandler.Resource
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

interface RepositoriesUseCase {
    suspend operator fun invoke(): Resource<RepositoriesResponse>
}

class RepositoriesUseCaseImpl(
    private val repository: GitHubRepository,
    private val mapper: RepositoriesMapper
) : RepositoriesUseCase {
    override suspend fun invoke() = withContext(IO) {
        repository.getRepositories()
    }
}