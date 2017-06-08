package br.com.concretesolutions.repository.request

import br.com.concretesolutions.repository.request.BaseRequest.Code
import br.com.concretesolutions.repository.request.BaseRequest.Code.*
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer

class MovieRequest(private val server: MockWebServer) {

    fun nowPlaying(code: Code) {
        when (code) {
            SUCCESS -> {
                server.enqueue(MockResponse()
                        .setResponseCode(200)
                        .setBody(RequestMocks.MovieMocks.nowPlaying_200))
            }

            ERROR -> {
                server.enqueue(MockResponse()
                        .setResponseCode(400)
                        .setBody(RequestMocks.MovieMocks.nowPlaying_200))
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
                        .setBody(RequestMocks.MovieMocks.popular_200))
            }

            ERROR -> {
                server.enqueue(MockResponse()
                        .setResponseCode(400)
                        .setBody(RequestMocks.MovieMocks.nowPlaying_200))
            }
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }
}

