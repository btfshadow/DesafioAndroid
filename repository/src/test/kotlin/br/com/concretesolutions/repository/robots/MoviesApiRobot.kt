package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.types.LanguageType
import br.com.concretesolutions.repository.api.types.RegionType
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.utils.RequestUtils.pageParam
import br.com.concretesolutions.repository.utils.RequestUtils.regionParam
import br.com.concretesolutions.repository.utils.RequestUtils.requestBaseUrl
import org.junit.Assert.assertEquals
import retrofit2.Call

fun moviesApi(func: MoviesApiRobot.() -> Unit) = MoviesApiRobot().apply { func() }

class MoviesApiRobot {

    @RegionType private var region = RegionType.BR
    @LanguageType private var language = LanguageType.PT_BR
    private var page: Int = 0

    fun page(page: Int): MoviesApiRobot {
        this.page = page
        return this
    }

    infix fun build(func: MoviesApiResult.() -> Unit): MoviesApiResult {
        val repositories = MoviesApi.get().getNowPlaying(region, language, page)
        return MoviesApiResult(repositories).apply { func() }
    }

}

class MoviesApiResult(private val repositories: Call<Page<Movie>>) {

    fun baseUrlIs(baseUrl: String) {
        assertEquals("Url is not correct", requestBaseUrl(repositories.request()), baseUrl)
    }

    fun pageIs(page: String) {
        assertEquals("Page is not correct", pageParam(repositories.request()), page)
    }

    fun regionIs(region: String) {
        assertEquals("Region is not correct", regionParam(repositories.request()), region)
    }
}

