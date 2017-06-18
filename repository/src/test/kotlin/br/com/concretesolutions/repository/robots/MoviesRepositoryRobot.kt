package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.MoviesRepository
import br.com.concretesolutions.repository.api.endpoint.MovieEndpoints.*
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.mock.request.RequestMock.Code.SUCCESS
import br.com.concretesolutions.repository.mock.request.mockRequest
import br.com.concretesolutions.repository.robots.MoviesRepositoryRobot.RequestedEndpoint.*
import br.com.concretesolutions.requestmatcher.RequestMatcherRule

internal fun moviesRepository(server: RequestMatcherRule, func: MoviesRepositoryRobot.() -> Unit): MoviesRepositoryRobot {
    return MoviesRepositoryRobot(server).apply { func() }
}

class MoviesRepositoryRobot(val server: RequestMatcherRule) {

    //region  Variables
    @RegionType private var region = RegionType.BR
    private var page: Int = 1
    @LanguageType private var lang = LanguageType.PT_BR
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
                nowPlaying(SUCCESS)
            }
        }
    }

    internal fun popular() {
        requestedEndpoint = POPULAR
        mockRequest(server) {
            movies {
                popular(SUCCESS)
            }
        }
    }

    fun topRated() {
        requestedEndpoint = TOP_RATED
        mockRequest(server) {
            movies {
                topRated(SUCCESS)
            }
        }
    }

    fun upComing() {
        requestedEndpoint = UP_COMING
        mockRequest(server) {
            movies {
                upComing(SUCCESS)
            }
        }
    }

    infix fun request(func: MoviesRepositoryResult.() -> Unit): MoviesRepositoryResult {
        when (requestedEndpoint) {
            NOW_PLAYING -> MoviesRepository.nowPlaying(lang, page, region)
            POPULAR -> MoviesRepository.popular(lang, page, region)
            TOP_RATED -> MoviesRepository.topRated(lang, page, region)
            UP_COMING -> MoviesRepository.upComing(lang, page, region)
        }
        return MoviesRepositoryResult(server).apply { func() }
    }

}

class MoviesRepositoryResult(private val server: RequestMatcherRule) {

    fun nowPlayingRequested() {
        pathIsCorrect(nowPlaying)
    }

    fun popularRequested() {
        pathIsCorrect(popular)
    }

    fun topRatedRequested() {
        pathIsCorrect(topRated)
    }

    fun upComingRequested() {
        pathIsCorrect(upcoming)
    }

    private fun pathIsCorrect(path: String) {
//        val request = server.takeRequest()
//        assertEquals(errorMessage("Path"), requestedEndpoint(request.path), "/$path")
    }

    private fun requestedEndpoint(fullPath: String): String {
        val queryStartIndex = fullPath.indexOf("?")
        return fullPath.substring(0, queryStartIndex)
    }
}
