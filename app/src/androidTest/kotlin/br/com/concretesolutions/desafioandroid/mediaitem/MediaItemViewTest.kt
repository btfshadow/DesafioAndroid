package br.com.concretesolutions.desafioandroid.mediaitem

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.repository.model.Media
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MediaItemViewTest : BaseViewTest<Media>(R.layout.v_media_item) {

    @Test
    fun whenDataIsOk_allViewsAreVisible() {
        mediaItem(rule) {
            everythingIsOk()
        } areVisible {
            mediaPoster()
            mediaTitle()
            mediaRating()
        }
    }

    @Test
    fun whenNoPoster_showBrokenImage() {
        mediaItem(rule) {
            noPoster()
        } areVisible {
            posterError()
        }
    }

    @Test
    fun whenNoTitle_showNoTitleText() {
        mediaItem(rule) {
            noTitle()
        } areVisible {
            noTitleText()
        }
    }

    @Test
    fun whenNoRating_showNoRatingText() {
        mediaItem(rule) {
            noRating()
        } areVisible {
            noRatingText()
        }
    }
}