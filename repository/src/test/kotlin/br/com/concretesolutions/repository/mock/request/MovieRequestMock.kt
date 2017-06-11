package br.com.concretesolutions.repository.mock.request

import br.com.concretesolutions.repository.mock.request.RequestMock.Code
import br.com.concretesolutions.repository.mock.request.RequestMock.Code.*
import br.com.concretesolutions.repository.mock.response.ResponseMocks
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

class MovieRequestMock(private val server: MockWebServer) {

    internal fun nowPlaying(code: Code) {
        when (code) {
            SUCCESS -> successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun popular(code: Code) {
        when (code) {
            SUCCESS -> successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun latest(code: Code) {
        when (code) {
            SUCCESS -> {
                server.enqueue(MockResponse()
                        .setResponseCode(200)
                        .setBody(ResponseMocks.MovieResponseMocks.latest_200))
            }

            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun topRated(code: Code) {
        when (code) {
            SUCCESS -> successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun upComing(code: Code) {
        when (code) {
            SUCCESS -> successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    private fun successMovieList() {
        server.enqueue(MockResponse()
                .setResponseCode(200)
                .setBody(ResponseMocks.MovieResponseMocks.movieList_200))
    }
}

