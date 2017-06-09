package br.com.concretesolutions.repository

import br.com.concretesolutions.repository.api.type.LanguageType
import br.com.concretesolutions.repository.robots.tvShowEndpoints
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class TVShowEndpointsTest {

    @Test
    fun endpointShouldBeTVShow() {
        tvShowEndpoints {
        } build {
            endpointIs("tv")
        }
    }

    @Test
    fun whenQueryLanguageX_languageParamShouldBe_X() {
        tvShowEndpoints {
            language(LanguageType.PT_BR)
        } build {
            languageIs("pt-BR")
        }
    }

}

