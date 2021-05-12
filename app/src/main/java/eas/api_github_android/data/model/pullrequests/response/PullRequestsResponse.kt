package eas.api_github_android.data.model.pullrequests.response

import eas.api_github_android.data.model.pullrequests.common.Head
import eas.api_github_android.data.model.pullrequests.common.Base
import eas.api_github_android.data.model.pullrequests.common.Links
import eas.api_github_android.data.model.pullrequests.common.User

data class PullRequestsResponse(
    val issueUrl: String? = null,
    val links: Links? = null,
    val diffUrl: String? = null,
    val createdAt: String? = null,
    val assignees: List<Any?>? = null,
    val requestedReviewers: List<Any?>? = null,
    val title: String? = null,
    val body: String? = null,
    val requestedTeams: List<Any?>? = null,
    val head: Head? = null,
    val authorAssociation: String? = null,
    val number: Int? = null,
    val patchUrl: String? = null,
    val updatedAt: String? = null,
    val mergeCommitSha: String? = null,
    val commentsUrl: String? = null,
    val reviewCommentUrl: String? = null,
    val id: Int? = null,
    val state: String? = null,
    val locked: Boolean? = null,
    val commitsUrl: String? = null,
    val closedAt: Any? = null,
    val statusesUrl: String? = null,
    val mergedAt: Any? = null,
    val url: String? = null,
    val labels: List<Any?>? = null,
    val milestone: Any? = null,
    val html_url: String? = null,
    val reviewCommentsUrl: String? = null,
    val assignee: Any? = null,
    val user: User? = null,
    val nodeId: String? = null,
    val base: Base? = null
)