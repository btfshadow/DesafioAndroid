package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.robots.movieEndpoints
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MovieEndpointsTest {

    @Test
    fun endpointShouldBeMovie() {
        movieEndpoints {
        } build {
            endpointIs("movie/")
        }
    }

    @Test
    fun whenQueryLanguageX_languageParamShouldBe_X() {
        movieEndpoints {
            language(LanguageType.EN_US)
        } build {
            languageIs("en-US")
        }
    }

}

