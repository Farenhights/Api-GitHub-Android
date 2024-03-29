package eas.api_github_android.presentation.ui.state

import eas.api_github_android.data.model.repositories.common.ItemsItem

data class RepositoriesState(
    val isLoading: Boolean = false,
    val repositories: List<ItemsItem> = arrayListOf(),
    val error: String = ""
)