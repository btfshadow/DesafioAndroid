package br.com.concretesolutions.desafioandroid.mediadetail

import android.content.Intent
import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.base.BaseActivityTest
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.desafioandroid.ui.feature.detail.MediaDetailActivity
import br.com.concretesolutions.kappuccino.utils.doWait
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaDetailTest: BaseActivityTest<MediaDetailActivity>(false, MediaDetailActivity::class.java) {

    @Test
    fun testInitial() {
        launch()
        doWait(30000L)
    }

    override fun intent(): Intent {
        val mediaItem = MockObjects.mediaItem()
        val intent = Intent().putExtra("KEY_MEDIA_ITEM", mediaItem)
        return intent
    }
}