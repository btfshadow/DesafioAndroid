package br.com.concretesolutions.repository.base

import br.com.concretesolutions.repository.api.MoviesApiMock
import br.com.concretesolutions.requestmatcher.LocalTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.After
import org.junit.Before
import org.junit.Rule

open class BaseTest {

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