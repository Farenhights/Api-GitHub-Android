package eas.api_github_android.presentation.ui.state

import eas.api_github_android.data.model.repositories.common.ItemsItem
import eas.api_github_android.domain.model.RepositoriesModel
import java.util.ArrayList

data class RepositoriesState(
    val isLoading: Boolean = false,
    val repositories: List<ItemsItem> = arrayListOf(),
    val error: String = ""
)