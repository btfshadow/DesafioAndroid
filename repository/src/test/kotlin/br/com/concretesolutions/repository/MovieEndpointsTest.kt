package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.robots.movieEndpoints
import br.com.concretesolutions.requestmatcher.LocalTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4



@RunWith(JUnit4::class)
class MovieEndpointsTest {

    @Test
    fun endpointShouldBeMovie() {
        movieEndpoints(server) {
        } build {
            endpointIs("/movie/popular")
        }
    }

    @Test
    fun whenQueryLanguageX_languageParamShouldBe_X() {
        movieEndpoints(server) {
            language(LanguageType.EN_US)
        } build {
            languageIs("en-US")
        }
    }

    @Test
    fun whenQueryRegionX_regionParamShouldBe_X() {
        movieEndpoints(server) {
            region(RegionType.BR)
        } build {
            regionIs("BR")
        }
    }

    // region Setup
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

