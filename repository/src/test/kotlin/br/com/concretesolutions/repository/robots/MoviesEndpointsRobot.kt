package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.utils.errorString
import br.com.concretesolutions.repository.utils.languageParam
import br.com.concretesolutions.repository.utils.requestEndpoint
import org.junit.Assert
import retrofit2.Call

fun movieEndpoints(func: MoviesEndpointsRobot.() -> Unit) = MoviesEndpointsRobot().apply { func() }

class MoviesEndpointsRobot {

    @RegionType private var region = RegionType.BR
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    infix fun build(func: MoviesEndpointsResult.() -> Unit): MoviesEndpointsResult {
        val repositories = MoviesApi.get().getPopular(region, lang, page)
        return MoviesEndpointsResult(repositories).apply { func() }
    }

    fun language(language: String): MoviesEndpointsRobot {
        this.lang = language
        return this
    }
}

class MoviesEndpointsResult(private val repositories: Call<Page<Movie>>) {
    fun languageIs(language: String) {
        Assert.assertEquals(errorString("Language"), languageParam(repositories.request()), language)
    }

    fun endpointIs(endpoint: String) {
        Assert.assertTrue(errorString("Endpoint"), requestEndpoint(repositories.request()).contains(endpoint))
    }
}

