package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MediaApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.mock.RequestMock
import br.com.concretesolutions.repository.mock.mockRequest
import br.com.concretesolutions.repository.model.Media
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import io.reactivex.Observable

fun tvShowEndpoints(server: RequestMatcherRule, func: TVShowEndpointsRobot.() -> Unit) = TVShowEndpointsRobot(server).apply { func() }

class TVShowEndpointsRobot(private val server: RequestMatcherRule) {
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    fun language(@LanguageType language: String): TVShowEndpointsRobot {
        this.lang = language
        return this
    }

    infix fun build(func: TVShowEndpointsResult.() -> Unit): TVShowEndpointsResult {
        val tvShows = MediaApi.get().getPopularTVShows(lang, page)
        return TVShowEndpointsResult(server, tvShows).apply { func() }
    }
}

class TVShowEndpointsResult(private val server: RequestMatcherRule, private val tvShows: Observable<Page<Media>>) {

    fun endpointIs(endpoint: String) {
        mockRequest(server)
        {
            movies {
                popular(RequestMock.Code.SUCCESS)
                        .pathIs(endpoint)
            }
        }
        tvShows.blockingFirst()
    }

    fun languageIs(language: String) {
        mockRequest(server)
        {
            movies {
                popular(RequestMock.Code.SUCCESS)
                        .queriesContain("language", language)
            }
        }
        tvShows.blockingFirst()
    }
}