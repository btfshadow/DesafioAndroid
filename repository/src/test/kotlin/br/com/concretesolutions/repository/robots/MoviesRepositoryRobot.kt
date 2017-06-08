package br.com.concretesolutions.repository.robots

import br.com.concretesolutions.repository.MoviesRepository
import br.com.concretesolutions.repository.api.ApiBuilder
import br.com.concretesolutions.repository.api.MoviesApi.okHttpClient
import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.api.MoviesService
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.request.BaseRequest.Code.SUCCESS
import br.com.concretesolutions.repository.request.request
import br.com.concretesolutions.repository.utils.errorString
import okhttp3.mockwebserver.MockWebServer
import org.junit.Assert.assertEquals
import retrofit2.converter.gson.GsonConverterFactory




fun moviesRepository(func: MoviesRepositoryRobot.() -> Unit) = MoviesRepositoryRobot().apply { func() }

class MoviesRepositoryRobot {
    private val server = MockWebServer()
    init {
        server.start()
        val rootUrl: String = server.url("/").toString()
        val moviesApi = ApiBuilder<MoviesService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(okHttpClient())
                .service(MoviesService::class.java)
                .build()
        MoviesApiMock.instance(moviesApi)
    }

    @RegionType private var region = RegionType.BR
    private var page: Int = 1
    @LanguageType private var lang = LanguageType.PT_BR

    fun nowPlaying() {
        request(server) {
            movies {
                nowPlaying(SUCCESS)
            }
        }
    }

    infix fun request(func: MoviesRepositoryResult.() -> Unit): MoviesRepositoryResult {
        MoviesRepository.nowPlaying(lang, page, region)
        return MoviesRepositoryResult(server).apply { func() }
    }

}

class MoviesRepositoryResult(private val server: MockWebServer) {

    fun nowPlayingRequested() {
        val request = server.takeRequest()
        assertEquals(errorString("Path"), requestedEndpoint(request.path), "/movie/now_playing")
        server.shutdown()
    }

    private fun requestedEndpoint(fullPath: String): String {
        val queryStartIndex = fullPath.indexOf("?")
        return fullPath.substring(0, queryStartIndex)
    }
}