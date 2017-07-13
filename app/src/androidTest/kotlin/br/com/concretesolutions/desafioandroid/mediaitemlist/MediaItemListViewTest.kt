package br.com.concretesolutions.desafioandroid.mediaitemlist

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.utils.doWait
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaItemListViewTest : BaseViewTest<MediaItemViewModel>(R.layout.v_media_list_item) {

    @Test
    fun overView_isVisible() {
        displayed {
            id(R.id.txt_media_list_item_overview)
        }
    }

    @Before
    fun setUp() {
        rule.activity.setObj(itemListViewModel())
        doWait(300L)
    }

    private fun itemListViewModel(): MediaItemViewModel {
        return MediaItemViewModel(MockObjects.mediaItem())
    }

}