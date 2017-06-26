package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.api.MediaApi
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.mock.RequestMock.Code.SUCCESS
import br.com.concretesolutions.repository.mock.mockRequest
import br.com.concretesolutions.repository.model.Media
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import io.reactivex.Observable


fun movieEndpoints(server: RequestMatcherRule, func: MoviesEndpointsRobot.() -> Unit) = MoviesEndpointsRobot(server).apply { func() }

class MoviesEndpointsRobot(private val server: RequestMatcherRule) {

    @RegionType private var region = RegionType.BR
    private var page: Int = 0
    @LanguageType private var lang = LanguageType.PT_BR

    infix fun build(func: MoviesEndpointsResult.() -> Unit): MoviesEndpointsResult {
        val movies = MediaApi.get().getPopularMovies(lang, page, region)
        return MoviesEndpointsResult(server, movies).apply { func() }
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

class MoviesEndpointsResult(private val server: RequestMatcherRule, private val movies: Observable<Page<Media>>) {
    fun languageIs(language: String) {
        mockRequest(server)
        {
            movies {
                popular(SUCCESS)
                        .queriesContain("language", language)
            }
        }
        movies.blockingFirst()
    }

    fun regionIs(region: String) {
        mockRequest(server)
        {
            movies {
                popular(SUCCESS)
                        .queriesContain("region", region)
            }
        }
        movies.blockingFirst()
    }

    fun endpointIs(endpoint: String) {
        mockRequest(server)
        {
            movies {
                popular(SUCCESS)
                        .pathIs(endpoint)
            }
        }
        movies.blockingFirst()
    }
}

