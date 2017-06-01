package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.desafioandroid.api.GitHubApi
import br.com.concretesolutions.desafioandroid.api.types.LanguageType
import br.com.concretesolutions.desafioandroid.api.types.SortType
import br.com.concretesolutions.desafioandroid.model.Page
import br.com.concretesolutions.desafioandroid.model.Repo
import br.com.concretesolutions.repository.utils.RequestUtils.languageParam
import br.com.concretesolutions.repository.utils.RequestUtils.removeQueryFromUrl
import br.com.concretesolutions.repository.utils.RequestUtils.requestEndpoint
import br.com.concretesolutions.repository.utils.RequestUtils.sortParam
import org.junit.Assert.assertEquals
import retrofit2.Call

fun repositories(func: GetRepositoriesRobot.() -> Unit) = GetRepositoriesRobot().apply { func() }

class GetRepositoriesRobot {
    @LanguageType private var languageType = LanguageType.JAVA
    @SortType private var sortType = SortType.STARS
    private var page: Int = 0

    fun languageIs(@LanguageType languageType: String): GetRepositoriesRobot {
        this.languageType = languageType
        return this
    }

    fun sortBy(@SortType sortType: String): GetRepositoriesRobot {
        this.sortType = sortType
        return this
    }

    infix fun get(func: GetRepositoriesResult.() -> Unit): GetRepositoriesResult {
        val repoRequest = GitHubApi.get().getRepositories(languageType, sortType, page)
        return GetRepositoriesResult(repoRequest).apply { func() }
    }
}

class GetRepositoriesResult(private val repoRequest: Call<Page<Repo>>) {

    fun endpointIs(endpoint: String) {
        val noQueryEndpoint = removeQueryFromUrl(requestEndpoint(repoRequest.request()))
        assertEquals("Endpoint is incorrect", noQueryEndpoint, endpoint)
    }

    fun languageIs(language: String) {
        val prefix = "language:"
        var langParam: String = language
        if (!language.contains(prefix))
            langParam = prefix + language
        assertEquals("Language is incorrect", languageParam(repoRequest.request()), langParam)
    }

    fun sortedBy(sort: String) {
        assertEquals("Sort is incorrect", sortParam(repoRequest.request()), sort)
    }

}
