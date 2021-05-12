package eas.api_github_android.data.model.pullrequests.common

data class Links(
    val comments: Comments? = null,
    val issue: Issue? = null,
    val self: Self? = null,
    val reviewComments: ReviewComments? = null,
    val commits: Commits? = null,
    val statuses: Statuses? = null,
    val html: Html? = null,
    val reviewComment: ReviewComment? = null
)
