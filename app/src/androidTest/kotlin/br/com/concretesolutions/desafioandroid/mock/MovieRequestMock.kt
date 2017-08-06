package br.com.concretesolutions.desafioandroid.mock

import br.com.concretesolutions.desafioandroid.mock.RequestMock.Code.*
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatchersGroup
import br.com.concretesolutions.requestmatcher.model.HttpMethod

class MovieRequestMock(private val server: RequestMatcherRule) {

    fun nowPlaying(code: RequestMock.Code): RequestMatchersGroup {
        return handleResponseCode(code).pathIs("/movie/nowPlaying")
    }

    fun popular(code: RequestMock.Code): RequestMatchersGroup {
        return handleResponseCode(code).pathIs("/movie/popular")
    }

    fun topRated(code: RequestMock.Code): RequestMatchersGroup {
        return handleResponseCode(code).pathIs("/movie/topRated")
    }

    fun upComing(code: RequestMock.Code): RequestMatchersGroup {
        return handleResponseCode(code).pathIs("/movie/upComing")
    }

    private fun handleResponseCode(code: RequestMock.Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> return errorResponse()
            EMPTY -> TODO()
            NOT_FOUND -> return errorNotFound()
        }
    }
    private fun successMovieList(): RequestMatchersGroup {
        return server.addFixture(200, "movie_page_200.json")
                .ifRequestMatches()
                .methodIs(HttpMethod.GET)
    }

    private fun errorResponse(): RequestMatchersGroup {
        return server.addFixture(401, "error_response_401.json")
                .ifRequestMatches()
                .methodIs(HttpMethod.GET)
    }

    private fun errorNotFound(): RequestMatchersGroup {
        return server.addFixture(404, "error_response_404.json")
                .ifRequestMatches()
                .methodIs(HttpMethod.GET)
    }
}

