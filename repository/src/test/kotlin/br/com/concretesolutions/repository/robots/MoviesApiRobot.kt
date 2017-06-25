package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MediaApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.model.TVShow
import br.com.concretesolutions.repository.utils.errorMessage
import br.com.concretesolutions.repository.utils.pageParam
import br.com.concretesolutions.repository.utils.requestBaseUrl
import org.junit.Assert.assertEquals
import retrofit2.Call

fun moviesApi(func: MoviesApiRobot.() -> Unit) = MoviesApiRobot().apply { func() }

class MoviesApiRobot {

    private var page: Int = 0

    fun page(page: Int): MoviesApiRobot {
        this.page = page
        return this
    }

    infix fun build(func: MoviesApiResult.() -> Unit): MoviesApiResult {
        val repositories = MediaApi.get().getPopularTVShows(LanguageType.PT_BR, page)
        return MoviesApiResult(repositories).apply { func() }
    }

}

class MoviesApiResult(private val repositories: Call<Page<TVShow>>) {

    fun baseUrlIs(baseUrl: String) {
        assertEquals(errorMessage("Url"), baseUrl, requestBaseUrl(repositories.request()))
    }

    fun pageIs(page: String) {
        assertEquals(errorMessage("Page"), page, pageParam(repositories.request()))
    }

}

