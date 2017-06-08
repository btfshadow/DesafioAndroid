package br.com.concretesolutions.repository.request

import br.com.concretesolutions.repository.request.BaseRequest.Code
import br.com.concretesolutions.repository.request.BaseRequest.Code.ERROR
import br.com.concretesolutions.repository.request.BaseRequest.Code.SUCCESS
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
        }
    }
}

