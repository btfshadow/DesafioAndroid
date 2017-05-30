package br.com.concretesolutions.desafioandroid.robots

import br.com.concretesolutions.desafioandroid.api.GitHubApi
import br.com.concretesolutions.desafioandroid.api.types.LanguageType
import br.com.concretesolutions.desafioandroid.api.types.SortType
import br.com.concretesolutions.desafioandroid.model.Page
import br.com.concretesolutions.desafioandroid.model.Repo
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import retrofit2.Call

fun gitHubApi(func: GitHubApiRobot.() -> Unit) = GitHubApiRobot().apply { func() }

class GitHubApiRobot {

    @LanguageType private var languageType = LanguageType.JAVA
    @SortType private var sortType = SortType.STARS
    private var page: Int = 0

    fun languageIs(@LanguageType languageType: String): GitHubApiRobot {
        this.languageType = languageType
        return this
    }

    fun sortBy(@SortType sortType: String): GitHubApiRobot {
        this.sortType = sortType
        return this
    }

    fun page(page: Int): GitHubApiRobot {
        this.page = page
        return this
    }

    infix fun build(func: GitHubApiResult.() -> Unit): GitHubApiResult {
        val searchRepos = GitHubApi.get().searchRepos(languageType, sortType, page)
        return GitHubApiResult(searchRepos).apply { func() }
    }

}

class GitHubApiResult(private val searchRepos: Call<Page<Repo>>) {

    private val languageIndex = 0
    private val sortIndex = 1
    private val pageIndex = 2

    fun baseUrlIs(baseUrl: String) {
        assertTrue("Url is incorrect", requestUrl().contains(baseUrl))
    }

    fun languageIs(language: String) {
        assertEquals("Language is incorrect", requestLanguage(), language)
    }

    fun sortedBy(sort: String) {
        assertEquals("Sort is incorrect", requestSort(), sort)
    }

    fun pageIs(page: String) {
        assertEquals("Page is incorrect", requestPage(), page)
    }

    private fun requestPage(): String {
        return searchRepos.request().url().queryParameterValue(pageIndex)
    }

    private fun requestSort(): String {
        return searchRepos.request().url().queryParameterValue(sortIndex)
    }

    private fun requestLanguage(): String {
        return searchRepos.request().url().queryParameterValue(languageIndex)
    }

    private fun requestUrl(): String {
        return searchRepos.request().url().toString()
    }
}

