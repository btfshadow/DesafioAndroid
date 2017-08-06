package br.com.concretesolutions.repository.base

import br.com.concretesolutions.repository.api.*
import br.com.concretesolutions.requestmatcher.LocalTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.After
import org.junit.Before
import org.junit.Rule
import retrofit2.converter.gson.GsonConverterFactory

open class BaseTest {

    // region Setup
    @JvmField @Rule
    val server: RequestMatcherRule = LocalTestRequestMatcherRule()

    @Before
    fun setUp() {
        val rootUrl: String = server.url("/").toString()
        val mediaMock = ApiBuilder<MediaService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(MediaApi.okHttpClient())
                .service(MediaService::class.java)
                .build()
        MediaApiMock.mock(mediaMock)
    }

    @After
    fun tearDown() {
        MediaApiMock.reset()
    }
    // endregion
}