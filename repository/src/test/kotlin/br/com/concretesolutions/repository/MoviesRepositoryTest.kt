package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.moviesRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MoviesRepositoryTest {

    @Test fun nowPlaying_shouldRequestNowPlayingMovies() {
        moviesRepository {
            nowPlaying()
        } request {
            nowPlayingRequested()
        }
    }

    @Test fun popular_shouldRequestPopularMovies() {
        moviesRepository {
            popular()
        } request {
            popularRequested()
        }
    }

    @Test fun latest_shouldRequestLatestMovie() {
        moviesRepository {
            latest()
        } request {
            latestRequested()
        }
    }

    @Test fun topRated_shouldRequestTopRatedMovies() {
        moviesRepository {
            topRated()
        } request {
            topRatedRequested()
        }
    }

    @Test fun upComing_shouldRequestUpComingMovies() {
        moviesRepository {
            upComing()
        } request {
            upComingRequested()
        }
    }
}

