package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.base.BaseTest
import br.com.concretesolutions.repository.robots.tvShowEndpoints
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TVShowEndpointsTest: BaseTest() {

    @Test
    fun endpointShouldBeTVShow() {
        tvShowEndpoints(server) {
        } build {
            endpointIs("/tv/popular")
        }
    }

    @Test
    fun whenQueryLanguageX_languageParamShouldBe_X() {
        tvShowEndpoints(server) {
            language(LanguageType.PT_BR)
        } build {
            languageIs("pt-BR")
        }
    }

}

