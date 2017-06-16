package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.utils.errorMessage
import io.reactivex.Observable

fun movieEndpoints(func: MoviesEndpointsRobot.() -> Unit) = MoviesEndpointsRobot().apply { func() }

class MoviesEndpointsRobot {

    @RegionType private var region = RegionType.BR
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    infix fun build(func: MoviesEndpointsResult.() -> Unit): MoviesEndpointsResult {
        val movies = MoviesApi.get().getPopularMovies(lang, page, region)
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

class MoviesEndpointsResult(private val movies: Observable<Page<Movie>>) {
    fun languageIs(language: String) {
//        Assert.assertEquals(errorMessage("Language"), languageParam(movies.request()), language)
        errorMessage("Language")
    }

    fun regionIs(region: String) {
//        Assert.assertEquals(errorMessage("Region"), regionParam(movies.request()), region)
        errorMessage("Language")
    }

    fun endpointIs(endpoint: String) {
//        Assert.assertEquals(errorMessage("Endpoint"), requestEndpoint(movies.request()), endpoint)
        errorMessage("Language")
    }
}

