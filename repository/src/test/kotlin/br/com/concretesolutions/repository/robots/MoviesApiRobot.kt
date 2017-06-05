package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.types.RegionType
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.utils.RequestUtils.pageParam
import br.com.concretesolutions.repository.utils.RequestUtils.requestBaseUrl
import org.junit.Assert.assertEquals
import retrofit2.Call

fun gitHubApi(func: GitHubApiRobot.() -> Unit) = GitHubApiRobot().apply { func() }

class GitHubApiRobot {

    @RegionType private var region = RegionType.BR
    private var page: Int = 0

    fun page(page: Int): GitHubApiRobot {
        this.page = page
        return this
    }

    infix fun build(func: GitHubApiResult.() -> Unit): GitHubApiResult {
        val repositories = MoviesApi.get().getNowPlaying(region, page)
        return GitHubApiResult(repositories).apply { func() }
    }

}

class GitHubApiResult(private val repositories: Call<Page<Movie>>) {

    fun baseUrlIs(baseUrl: String) {
        assertEquals("Url is incorrect", requestBaseUrl(repositories.request()), baseUrl)
    }

    fun pageIs(page: String) {
        assertEquals("Page is incorrect", pageParam(repositories.request()), page)
    }
}

