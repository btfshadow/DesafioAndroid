package br.com.concretesolutions.desafioandroid.base

import android.content.Intent
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.intent.rule.IntentsTestRule
import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.desafioandroid.ui.base.BaseActivity
import br.com.concretesolutions.kappuccino.utils.doWait
import br.com.concretesolutions.requestmatcher.InstrumentedTestRequestMatcherRule
import br.com.concretesolutions.requestmatcher.RequestMatcherRule
import org.junit.Before
import org.junit.Rule

abstract class BaseActivityTest<T : BaseActivity>(val autoLaunch: Boolean = true, activityClass: Class<T>) {

    @Rule @JvmField val server: RequestMatcherRule = InstrumentedTestRequestMatcherRule()
    @Rule @JvmField val rule: ActivityTestRule<T> = IntentsTestRule(activityClass, true, false)

    @Before
    @Throws(InterruptedException::class)
    open fun baseTestSetup() {
        if (autoLaunch) launch()
    }

    fun launch() {
        doWait(300)
        InstrumentationRegistry.getInstrumentation().waitForIdleSync()
        rule.launchActivity(intent())
    }

    open fun intent(): Intent {
        return Intent()
    }
}