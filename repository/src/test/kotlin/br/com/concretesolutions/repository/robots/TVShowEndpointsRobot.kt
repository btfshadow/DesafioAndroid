package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MoviesApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.model.TVShow
import br.com.concretesolutions.repository.utils.errorString
import br.com.concretesolutions.repository.utils.languageParam
import br.com.concretesolutions.repository.utils.requestEndpoint
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import retrofit2.Call

fun tvShowEndpoints(func: TVShowEndpointsRobot.() -> Unit) = TVShowEndpointsRobot().apply { func() }

class TVShowEndpointsRobot {
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    fun language(@LanguageType language: String): TVShowEndpointsRobot {
        this.lang = language
        return this
    }

    infix fun build(func: TVShowEndpointsResult.() -> Unit): TVShowEndpointsResult {
        val tvShows = MoviesApi.get().getPopular(lang, page)
        return TVShowEndpointsResult(tvShows).apply { func() }
    }
}

class TVShowEndpointsResult(private val tvShows: Call<Page<TVShow>>) {

    fun endpointIs(endpoint: String) {
        assertTrue(errorString("Endpoint"), requestEndpoint(tvShows.request()).contains(endpoint))
    }

    fun languageIs(language: String) {
        assertEquals(errorString("Language"), languageParam(tvShows.request()), language)
    }
}