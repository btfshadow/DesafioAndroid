package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.MoviesRepository
import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.request.BaseRequest.Code.SUCCESS
import br.com.concretesolutions.repository.request.request
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

    @RegionType private var region = RegionType.BR
    private var page: Int = 1
    @LanguageType private var lang = LanguageType.PT_BR

    internal fun nowPlaying() {
        request(server) {
            movies {
                nowPlaying(SUCCESS)
            }
        }
    }

    internal fun popular() {
        request(server) {
            movies {
                popular(SUCCESS)
            }
        }
    }

    internal fun latest() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal fun topRated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal fun upComing() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal infix fun request(func: MoviesRepositoryResult.() -> Unit): MoviesRepositoryResult {
        MoviesRepository.nowPlaying(lang, page, region)
        return MoviesRepositoryResult(server).apply { func() }
    }

}

class MoviesRepositoryResult(private val server: MockWebServer) {

    fun nowPlayingRequested() {
        val request = server.takeRequest()
        assertEquals(errorMessage("Path"), requestedEndpoint(request.path), "/movie/now_playing")
        server.shutdown()
    }

    private fun requestedEndpoint(fullPath: String): String {
        val queryStartIndex = fullPath.indexOf("?")
        return fullPath.substring(0, queryStartIndex)
    }

    fun popularRequested() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun latestRequested() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun topRatedRequested() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun upComingRequested() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}