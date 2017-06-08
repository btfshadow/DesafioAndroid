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
}

