package br.com.concretesolutions.repository.mock.request

import br.com.concretesolutions.repository.mock.request.RequestMock.Code
import br.com.concretesolutions.repository.mock.request.RequestMock.Code.*
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatchersGroup
import br.com.concretesolutions.requestmatcher.model.HttpMethod

class MovieRequestMock(private val server: RequestMatcherRule) {

    internal fun nowPlaying(code: Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun popular(code: Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun topRated(code: Code): RequestMatchersGroup {
        when (code) {
            SUCCESS -> return successMovieList()
            ERROR -> TODO()
            EMPTY -> TODO()
            NOT_FOUND -> TODO()
        }
    }

    internal fun upComing(code: Code): RequestMatchersGroup {
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

