package eas.api_github_android.domain.mapper

import eas.api_github_android.data.model.pullrequests.response.PullRequestsResponse
import eas.api_github_android.domain.model.PullRequestsModel

class PullRequestsMapperImpl {
    companion object {
        fun mapFrom(from: PullRequestsResponse) = PullRequestsModel(
            issueUrl = from.issueUrl,
            links = from.links,
            diffUrl = from.diffUrl,
            createdAt = from.createdAt,
            assignees = from.assignees,
            requestedReviewers = from.requestedReviewers,
            title = from.title,
            body = from.body,
            requestedTeams = from.requestedTeams,
            head = from.head,
            authorAssociation = from.authorAssociation,
            number = from.number,
            patchUrl = from.patchUrl,
            updatedAt = from.updatedAt,
            mergeCommitSha = from.mergeCommitSha,
            commentsUrl = from.commentsUrl,
            reviewCommentUrl = from.reviewCommentUrl,
            id = from.id,
            state = from.state,
            locked = from.locked,
            commitsUrl = from.commitsUrl,
            closedAt = from.closedAt,
            statusesUrl = from.statusesUrl,
            mergedAt = from.mergedAt,
            url = from.url,
            labels = from.labels,
            milestone = from.milestone,
            html_url = from.html_url,
            reviewCommentsUrl = from.reviewCommentsUrl,
            assignee = from.assignee,
            user = from.user,
            nodeId = from.nodeId,
            base = from.base
        )
    }
}