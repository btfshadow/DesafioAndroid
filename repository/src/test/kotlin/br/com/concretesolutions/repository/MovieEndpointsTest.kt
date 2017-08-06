package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.api.type.RegionType
import br.com.concretesolutions.repository.base.BaseTest
import br.com.concretesolutions.repository.robots.movieEndpoints
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4



@RunWith(JUnit4::class)
class MovieEndpointsTest: BaseTest() {

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
}

