package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.MoviesRepository
import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.mock.request.RequestMock.Code.SUCCESS
import br.com.concretesolutions.repository.mock.request.mockRequest
import br.com.concretesolutions.repository.robots.MoviesRepositoryRobot.RequestedEndpoint.*
import br.com.concretesolutions.repository.utils.errorMessage
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals

internal fun moviesRepository(func: MoviesRepositoryRobot.() -> Unit) = MoviesRepositoryRobot().apply { func() }

class MoviesRepositoryRobot {
    private val server = MockWebServer()
    init {
        server.start()
        MoviesApiMock.mock(server)
    }

    //region  Variables
    @RegionType private var region = RegionType.BR
    private var page: Int = 1
    @LanguageType private var lang = LanguageType.PT_BR
    enum class RequestedEndpoint(val endpointCode: Int) {
        NOW_PLAYING(0),
        LATEST(1),
        POPULAR(2),
        TOP_RATED(3),
        UP_COMING(4)
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

    internal fun latest() {
        requestedEndpoint = LATEST
        mockRequest(server) {
            movies {
                latest(SUCCESS)
            }
        }
    }

    internal fun topRated() {
        requestedEndpoint = TOP_RATED
        mockRequest(server) {
            movies {
                topRated(SUCCESS)
            }
        }
    }

    internal fun upComing() {
        requestedEndpoint = UP_COMING
        mockRequest(server) {
            movies {
                upComing(SUCCESS)
            }
        }
    }

    internal infix fun request(func: MoviesRepositoryResult.() -> Unit): MoviesRepositoryResult {
        when (requestedEndpoint) {
            NOW_PLAYING -> MoviesRepository.nowPlaying(lang, page, region)
            POPULAR -> MoviesRepository.popular(lang, page, region)
            LATEST -> MoviesRepository.latest(lang, page, region)
            TOP_RATED -> MoviesRepository.topRated(lang, page, region)
            UP_COMING -> MoviesRepository.upComing(lang, page, region)
        }
        return MoviesRepositoryResult(server).apply { func() }
    }

}

class MoviesRepositoryResult(private val server: MockWebServer) {

    internal fun nowPlayingRequested() {
        pathIsCorrect("now_playing")
    }

    internal fun popularRequested() {
        pathIsCorrect("popular")
    }

    internal fun latestRequested() {
        pathIsCorrect("latest")
    }

    internal fun topRatedRequested() {
        pathIsCorrect("top_rated")
    }

    internal fun upComingRequested() {
        pathIsCorrect("upcoming")
    }

    private fun pathIsCorrect(path: String) {
        val request = server.takeRequest()
        assertEquals(errorMessage("Path"), requestedEndpoint(request.path), "/movie/"+path)
        server.shutdown()
    }

    private fun requestedEndpoint(fullPath: String): String {
        val queryStartIndex = fullPath.indexOf("?")
        return fullPath.substring(0, queryStartIndex)
    }
}
