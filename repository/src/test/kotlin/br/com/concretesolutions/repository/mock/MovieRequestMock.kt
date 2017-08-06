package br.com.concretesolutions.repository.mock

import br.com.concretesolutions.repository.mock.RequestMock.Code.*
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatchersGroup
import br.com.concretesolutions.requestmatcher.model.HttpMethod

class MovieRequestMock(private val server: RequestMatcherRule) {

    fun nowPlaying(code: RequestMock.Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    fun popular(code: RequestMock.Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    fun topRated(code: RequestMock.Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    fun upComing(code: RequestMock.Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    private fun successMovieList(): RequestMatchersGroup {
        return server.addFixture(200, "movie_page_200.json")
                .ifRequestMatches()
                .methodIs(HttpMethod.GET)
    }
}

