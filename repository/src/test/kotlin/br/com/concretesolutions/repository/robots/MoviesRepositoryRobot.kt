package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.MoviesRepository
import br.com.concretesolutions.repository.api.endpoint.MovieEndpoints.*
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.mock.RequestMock.Code.SUCCESS
import br.com.concretesolutions.repository.mock.mockRequest
import br.com.concretesolutions.repository.model.Movie
import br.com.concretesolutions.repository.model.Page
import br.com.concretesolutions.repository.robots.MoviesRepositoryRobot.RequestedEndpoint.*
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatchersGroup
import io.reactivex.Observable

internal fun moviesRepository(server: RequestMatcherRule, func: MoviesRepositoryRobot.() -> Unit): MoviesRepositoryRobot {
    return MoviesRepositoryRobot(server).apply { func() }
}

class MoviesRepositoryRobot(val server: RequestMatcherRule) {

    //region  Variables
    @RegionType private var region = RegionType.BR
    private var page: Int = 1
    @LanguageType private var lang = LanguageType.PT_BR
    private var requestMatcher: RequestMatchersGroup? = null
    enum class RequestedEndpoint(val endpointCode: Int) {
        NOW_PLAYING(0),
        POPULAR(1),
        TOP_RATED(2),
        UP_COMING(3)
    }

    var requestedEndpoint: RequestedEndpoint = NOW_PLAYING
    //endregion

    internal fun nowPlaying() {
        requestedEndpoint = NOW_PLAYING
        mockRequest(server) {
            movies {
                requestMatcher = nowPlaying(SUCCESS)
            }
        }
    }

    internal fun popular() {
        requestedEndpoint = POPULAR
        mockRequest(server) {
            movies {
                requestMatcher = popular(SUCCESS)
            }
        }
    }

    fun topRated() {
        requestedEndpoint = TOP_RATED
        mockRequest(server) {
            movies {
                requestMatcher = topRated(SUCCESS)
            }
        }
    }

    fun upComing() {
        requestedEndpoint = UP_COMING
        mockRequest(server) {
            movies {
                requestMatcher = upComing(SUCCESS)
            }
        }
    }

    infix fun request(func: MoviesRepositoryResult.() -> Unit): MoviesRepositoryResult {
        val movies: Observable<Page<Movie>>
        when (requestedEndpoint) {
            NOW_PLAYING -> movies = MoviesRepository.nowPlaying(lang, page, region)
            POPULAR -> movies = MoviesRepository.popular(lang, page, region)
            TOP_RATED -> movies = MoviesRepository.topRated(lang, page, region)
            UP_COMING -> movies = MoviesRepository.upComing(lang, page, region)
        }
        return MoviesRepositoryResult(requestMatcher, movies).apply { func() }
    }

}

class MoviesRepositoryResult(private val requestMatcher: RequestMatchersGroup?, private val movies: Observable<Page<Movie>>) {

    fun nowPlayingRequested() {
        requestMatcher?.pathIs(getPath(nowPlaying))
        movies.blockingFirst()
    }

    fun popularRequested() {
        requestMatcher?.pathIs(getPath(popular))
        movies.blockingFirst()
    }

    fun topRatedRequested() {
        requestMatcher?.pathIs(getPath(topRated))
        movies.blockingFirst()
    }

    fun upComingRequested() {
        requestMatcher?.pathIs(getPath(upcoming))
        movies.blockingFirst()
    }

    private fun getPath(path: String): String {
        return "/$path"
    }
}
