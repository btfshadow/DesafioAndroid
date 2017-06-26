package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.base.BaseTest
import br.com.concretesolutions.repository.robots.moviesRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MoviesRepositoryTest: BaseTest() {

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
}

