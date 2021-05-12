package eas.api_github_android.domain.model

import eas.api_github_android.data.model.repositories.common.ItemsItem

data class RepositoriesModel(
    val totalCount: Int? = null,
    val incompleteResults: Boolean? = null,
    val items: ArrayList<ItemsItem> = arrayListOf()
)