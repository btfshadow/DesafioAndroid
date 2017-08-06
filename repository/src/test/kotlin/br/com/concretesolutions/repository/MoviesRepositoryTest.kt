package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.robots.moviesRepository
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
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

    @Test fun popular_shouldRequestPopularMovies() {
        moviesRepository(server) {
            popular()
        } request {
            popularRequested()
        }
    }

    @Test fun latest_shouldRequestLatestMovie() {
        moviesRepository(server) {
            latest()
        } request {
            latestRequested()
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
    private val server = MockWebServer()

    @Before
    fun setUp() {
        server.start()
        MoviesApiMock.mock(server)
    }

    @After
    fun tearDown() {
        server.shutdown()
        MoviesApiMock.reset()
    }
    // endregion
}

