package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.robots.moviesApi
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class MediaApiTest {

    @Test
    fun baseUrl_isCorrect() {
        moviesApi {
        } build {
           baseUrlIs(BuildConfig.BASE_URL)
        }
    }

    @Test
    fun whenRequestPageX_pageParamShouldBe_X() {
        moviesApi {
            page(1)
        } build {
            pageIs("1")
        }
    }

}