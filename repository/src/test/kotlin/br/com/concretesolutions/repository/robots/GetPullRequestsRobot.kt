package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.desafioandroid.model.Page
import br.com.concretesolutions.desafioandroid.model.PullRequest
import br.com.concretesolutions.repository.utils.RequestUtils.requestEndpoint
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue

fun pullRequests(func: GetPullRequestsRobot.() -> Unit) = GetPullRequestsRobot().apply { func() }

class GetPullRequestsRobot {

    private var creator: String = ""
    private var repository: String = ""

    infix fun get(func: GetPullRequestsResult.() -> Unit): GetPullRequestsResult {
        val getPullRequests = br.com.concretesolutions.desafioandroid.api.GitHubApi.get().getPullRequests(creator, repository)
        return GetPullRequestsResult(getPullRequests).apply { func() }
    }

    fun creator(creator: String): GetPullRequestsRobot {
        this.creator = creator
        return this
    }

    fun repository(repository: String): GetPullRequestsRobot {
        this.repository = repository
        return this
    }
}

class GetPullRequestsResult(private val pullRequests: retrofit2.Call<Page<PullRequest>>) {
    private val CREATOR_INDEX = 1
    private val REPOSITORY_INDEX = 2

    fun endPointIs(endpoint: String) {
        assertEquals("Endpoint is incorrect", requestEndpoint(pullRequests.request()), endpoint)
    }

    fun creatorIs(creator: String) {
        endPointContains(CREATOR_INDEX, creator)
    }

    fun repositoryIs(repository: String) {
        endPointContains(REPOSITORY_INDEX, repository)
    }

    private fun endPointContains(index: Int, parameter: String) {
        val pathParts = requestEndpoint(pullRequests.request()).split("/")
        assertTrue(index > 0)
        assertEquals("Parameter is incorrect", pathParts[index], parameter)
    }

}
