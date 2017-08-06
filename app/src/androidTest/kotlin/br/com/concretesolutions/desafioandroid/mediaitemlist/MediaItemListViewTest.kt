package br.com.concretesolutions.desafioandroid.mediaitemlist

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.utils.doWait
import br.com.concretesolutions.repository.model.Media
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaItemListViewTest : BaseViewTest<Media>(R.layout.v_media_list_item) {

    @Test
    fun overView_isVisible() {
        displayed {
            id(R.id.txt_media_list_item_overview)
        }
    }

    @Before
    fun setUp() {
        rule.activity.setObj(mediaItemList())
        doWait(300L)
    }

    private fun mediaItemList() = MockObjects.mediaItem()

}