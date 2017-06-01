package br.com.concretesolutions.desafioandroid.robots

import br.com.concretesolutions.desafioandroid.api.GitHubApi
import br.com.concretesolutions.desafioandroid.api.types.LanguageType
import br.com.concretesolutions.desafioandroid.api.types.SortType
import br.com.concretesolutions.desafioandroid.model.Page
import br.com.concretesolutions.desafioandroid.model.Repo
import br.com.concretesolutions.desafioandroid.utils.RequestUtils.pageParam
import br.com.concretesolutions.desafioandroid.utils.RequestUtils.requestBaseUrl
import org.junit.Assert.assertEquals
import retrofit2.Call

fun gitHubApi(func: GitHubApiRobot.() -> Unit) = GitHubApiRobot().apply { func() }

class GitHubApiRobot {

    @LanguageType private var languageType = LanguageType.JAVA
    @SortType private var sortType = SortType.STARS
    private var page: Int = 0

    fun page(page: Int): GitHubApiRobot {
        this.page = page
        return this
    }

    infix fun build(func: GitHubApiResult.() -> Unit): GitHubApiResult {
        val repositories = GitHubApi.get().getRepositories(languageType, sortType, page)
        return GitHubApiResult(repositories).apply { func() }
    }

}

class GitHubApiResult(private val repositories: Call<Page<Repo>>) {

    fun baseUrlIs(baseUrl: String) {
        assertEquals("Url is incorrect", requestBaseUrl(repositories.request()), baseUrl)
    }

    fun pageIs(page: String) {
        assertEquals("Page is incorrect", pageParam(repositories.request()), page)
    }
}

