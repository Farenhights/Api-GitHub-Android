package eas.api_github_android.data.model.repositories.response

import eas.api_github_android.data.model.repositories.common.ItemsItem
import java.util.*

data class RepositoriesResponse(
    val totalCount: Int? = null,
    val incompleteResults: Boolean? = null,
    val items: ArrayList<ItemsItem> = arrayListOf()
)