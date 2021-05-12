package eas.api_github_android.domain.mapper

import eas.api_github_android.data.model.repositories.response.RepositoriesResponse
import eas.api_github_android.domain.model.RepositoriesModel
import eas.api_github_android.network.statushandler.Resource

class RepositoriesMapper {
    fun mapFrom(from: Resource<RepositoriesResponse>) = RepositoriesModel(
        totalCount = from.data?.totalCount,
        incompleteResults = from.data?.incompleteResults,
        items = from.data?.items!!
    )
}