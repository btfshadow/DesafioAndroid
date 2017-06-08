package br.com.concretesolutions.repository.request

import okhttp3.mockwebserver.MockWebServer

fun request(server: MockWebServer, func: BaseRequest.() -> Unit) = BaseRequest(server).apply { func() }

class BaseRequest(private val server: MockWebServer) {
    fun movies(func: MovieRequest.() -> Unit) = MovieRequest(server).apply { func() }

    enum class Code(val code: Int) {
        SUCCESS(200),
        EMPTY(200),
        NOT_FOUND(404),
        ERROR(400)
    }
}