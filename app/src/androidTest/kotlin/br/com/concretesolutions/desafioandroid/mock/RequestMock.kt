package br.com.concretesolutions.desafioandroid.mock

import br.com.concretesolutions.requestmatcher.RequestMatcherRule

fun mockRequest(server: RequestMatcherRule, func: RequestMock.() -> Unit) = RequestMock(server).apply { func() }

open class RequestMock(private val server: RequestMatcherRule) {
    fun movies(func: MovieRequestMock.() -> Unit) = MovieRequestMock(server).apply { func() }

    enum class Code(val code: Int) {
        SUCCESS(code = 200),
        EMPTY(code = 200),
        NOT_FOUND(code = 404),
        ERROR(code = 400)
    }
}