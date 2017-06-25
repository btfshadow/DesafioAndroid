package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MediaApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.model.TVShow
import br.com.concretesolutions.repository.utils.errorMessage
import br.com.concretesolutions.repository.utils.languageParam
import br.com.concretesolutions.repository.utils.requestEndpoint
import org.junit.Assert.assertEquals
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
        val tvShows = MediaApi.get().getPopularTVShows(lang, page)
        return TVShowEndpointsResult(tvShows).apply { func() }
    }
}

class TVShowEndpointsResult(private val tvShows: Call<Page<TVShow>>) {

    fun endpointIs(endpoint: String) {
        assertEquals(errorMessage("Endpoint"), requestEndpoint(tvShows.request()), endpoint)
    }

    fun languageIs(language: String) {
        assertEquals(errorMessage("Language"), languageParam(tvShows.request()), language)
    }
}