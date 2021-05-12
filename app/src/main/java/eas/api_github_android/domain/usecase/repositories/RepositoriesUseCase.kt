package eas.api_github_android.domain.usecase.repositories

import eas.api_github_android.domain.mapper.RepositoriesMapper
import eas.api_github_android.domain.model.RepositoriesModel
import eas.api_github_android.data.GitHubRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

interface RepositoriesUseCase {
    suspend operator fun invoke(): RepositoriesModel
}

class RepositoriesUseCaseImpl(
    private val repository: GitHubRepository,
    private val mapper: RepositoriesMapper
) : RepositoriesUseCase {
    override suspend fun invoke(): RepositoriesModel = withContext(IO) {
        mapper.mapFrom(repository.getRepositories())
    }
}