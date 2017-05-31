package br.com.concretesolutions.desafioandroid.robots

import br.com.concretesolutions.desafioandroid.BuildConfig
import br.com.concretesolutions.desafioandroid.api.GitHubApi
import br.com.concretesolutions.desafioandroid.model.Page
import br.com.concretesolutions.desafioandroid.model.PullRequest
import org.junit.Assert.assertEquals
import retrofit2.Call

fun pullRequests(func: GetPullRequestsRobot.() -> Unit) = GetPullRequestsRobot().apply { func() }

class GetPullRequestsRobot {

    var creator: String = ""
    var repository: String = ""

    infix fun get(func: GetPullRequestsResult.() -> Unit): GetPullRequestsResult {
        val getPullRequests = GitHubApi.get().getPullRequests(creator, repository)
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

class GetPullRequestsResult(private val pullRequests: Call<Page<PullRequest>>) {
    fun endPointIs(endpoint: String) {
        assertEquals("Endpoint is incorrect", requestEndpoint(), endpoint)
    }

    private fun requestEndpoint(): String {
        val baseUrlSize = BuildConfig.BASE_URL.length
        return pullRequests.request().url().toString().substring(baseUrlSize)
    }

}
