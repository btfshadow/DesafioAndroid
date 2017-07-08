package br.com.concretesolutions.desafioandroid.mediaitem

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaItemViewTest : BaseViewTest(R.layout.v_media_item) {

    @Test
    fun whenDataIsOk_allViewsAreVisible() {
        mediaItem(rule) {
            everythingIsOk()
        } areVisible {
            mediaPoster()
            mediaName()
            mediaRating()
        }
    }
}