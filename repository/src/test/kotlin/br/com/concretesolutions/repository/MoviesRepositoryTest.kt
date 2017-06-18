package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.robots.moviesRepository
import br.com.concretesolutions.requestmatcher.LocalTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MoviesRepositoryTest {

    @Test fun nowPlaying_shouldRequestNowPlayingMovies() {
        moviesRepository(server) {
            nowPlaying()
        } request {
            nowPlayingRequested()
        }
    }

    @Ignore
    @Test fun popular_shouldRequestPopularMovies() {
        moviesRepository(server) {
            popular()
        } request {
            popularRequested()
        }
    }

    @Test fun topRated_shouldRequestTopRatedMovies() {
        moviesRepository(server) {
            topRated()
        } request {
            topRatedRequested()
        }
    }

    @Test fun upComing_shouldRequestUpComingMovies() {
        moviesRepository(server) {
            upComing()
        } request {
            upComingRequested()
        }
    }

    // region Initialization
    @JvmField @Rule
    val server: RequestMatcherRule = LocalTestRequestMatcherRule()

    @Before
    fun setUp() {
        MoviesApiMock.mock(server)
    }

    @After
    fun tearDown() {
        MoviesApiMock.reset()
    }
    // endregion
}

