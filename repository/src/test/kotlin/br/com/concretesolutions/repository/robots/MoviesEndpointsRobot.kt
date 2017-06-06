package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.utils.errorString
import br.com.concretesolutions.repository.utils.languageParam
import br.com.concretesolutions.repository.utils.regionParam
import br.com.concretesolutions.repository.utils.requestEndpoint
import org.junit.Assert
import retrofit2.Call

fun movieEndpoints(func: MoviesEndpointsRobot.() -> Unit) = MoviesEndpointsRobot().apply { func() }

class MoviesEndpointsRobot {

    @RegionType private var region = RegionType.BR
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    infix fun build(func: MoviesEndpointsResult.() -> Unit): MoviesEndpointsResult {
        val movies = MoviesApi.get().getPopular(lang, page, region)
        return MoviesEndpointsResult(movies).apply { func() }
    }

    fun language(@LanguageType language: String): MoviesEndpointsRobot {
        this.lang = language
        return this
    }

    fun region(@RegionType region: String): MoviesEndpointsRobot {
        this.region = region
        return this
    }
}

class MoviesEndpointsResult(private val movies: Call<Page<Movie>>) {
    fun languageIs(language: String) {
        Assert.assertEquals(errorString("Language"), languageParam(movies.request()), language)
    }

    fun regionIs(region: String) {
        Assert.assertEquals(errorString("Region"), regionParam(movies.request()), region)
    }

    fun endpointIs(endpoint: String) {
        Assert.assertTrue(errorString("Endpoint"), requestEndpoint(movies.request()).contains(endpoint))
    }
}

