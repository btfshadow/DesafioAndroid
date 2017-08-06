package br.com.concretesolutions.desafioandroid.base

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity
import br.com.concretesolutions.kappuccino.utils.doWait
import br.com.concretesolutions.repository.api.ApiBuilder
import br.com.concretesolutions.repository.api.MediaApi
import br.com.concretesolutions.repository.api.MediaApiMock
import br.com.concretesolutions.repository.api.MediaService
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.Before
import org.junit.Rule
import retrofit2.converter.gson.GsonConverterFactory


abstract class BaseActivityTest<T : BaseActivity>(val autoLaunch: Boolean = true, activityClass: Class<T>) {

    @Rule @JvmField val server: RequestMatcherRule = InstrumentedTestRequestMatcherRule()
    @Rule @JvmField val rule: ActivityTestRule<T> = IntentsTestRule(activityClass, true, false)

    @Before
    @Throws(InterruptedException::class)
    open fun baseTestSetup() {
        val rootUrl: String = server.url("/").toString()
        val mediaMock = ApiBuilder<MediaService>()
                .baseUrl(rootUrl)
                .converterFactory(GsonConverterFactory.create())
                .okHttpClient(MediaApi.okHttpClient())
                .service(MediaService::class.java)
                .build()

        MediaApiMock.mock(mediaMock)

        if (autoLaunch) launch()
    }

    fun launch() {
        InstrumentationRegistry.getInstrumentation().waitForIdleSync()
        rule.launchActivity(intent())
        doWait(300)
    }

    open fun intent(): Intent {
        return Intent()
    }
}