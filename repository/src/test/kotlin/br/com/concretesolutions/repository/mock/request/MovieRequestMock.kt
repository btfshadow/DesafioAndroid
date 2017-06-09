package br.com.concretesolutions.repository.mock.request

import br.com.concretesolutions.repository.mock.request.RequestMock.Code
import br.com.concretesolutions.repository.mock.request.RequestMock.Code.*
import br.com.concretesolutions.repository.mock.response.ResponseMocks
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

class MovieRequestMock(private val server: MockWebServer) {

    fun nowPlaying(code: Code) {
        when (code) {
            SUCCESS -> {
                server.enqueue(MockResponse()
                        .setResponseCode(200)
                        .setBody(ResponseMocks.MovieResponseMocks.nowPlaying_200))
            }

            ERROR -> {
                server.enqueue(MockResponse()
                        .setResponseCode(400)
                        .setBody(ResponseMocks.MovieResponseMocks.nowPlaying_200))
            }
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    fun popular(code: Code) {
        when (code) {
            SUCCESS -> {
                server.enqueue(MockResponse()
                        .setResponseCode(200)
                        .setBody(ResponseMocks.MovieResponseMocks.popular_200))
            }

            ERROR -> {
                server.enqueue(MockResponse()
                        .setResponseCode(400)
                        .setBody(ResponseMocks.MovieResponseMocks.nowPlaying_200))
            }
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }
}

