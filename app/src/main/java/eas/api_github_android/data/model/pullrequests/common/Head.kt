package eas.api_github_android.data.model.pullrequests.common

data class Head(
    val ref: String? = null,
    val repo: Repo? = null,
    val label: String? = null,
    val sha: String? = null,
    val user: User? = null
)
