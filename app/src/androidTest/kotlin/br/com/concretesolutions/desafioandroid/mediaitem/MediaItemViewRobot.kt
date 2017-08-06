package br.com.concretesolutions.desafioandroid.mediaitem

import android.support.annotation.DrawableRes
import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.ViewTestActivity
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.utils.doWait
import br.com.concretesolutions.repository.model.Media
import org.mockito.Mockito

fun mediaItem(rule: ActivityTestRule<ViewTestActivity>, func: MediaItemViewRobot.() -> Unit) = MediaItemViewRobot(rule).apply { func() }

class MediaItemViewRobot(val rule: ActivityTestRule<ViewTestActivity>) {

    fun everythingIsOk() : MediaItemViewRobot {
        bindDataToView(itemViewModel())
        return this
    }

    fun noPoster(): MediaItemViewRobot {
        val mediaMock = mockMediaModel()
        Mockito.`when`(mediaMock.poster()).thenReturn("")
        bindDataToView(mediaMock)
        return this
    }

    fun noTitle() : MediaItemViewRobot {
        val mediaMock = mockMediaModel()
        Mockito.`when`(mediaMock.title()).thenReturn("")
        bindDataToView(mediaMock)
        return this
    }

    fun noRating() : MediaItemViewRobot {
        val mediaMock = mockMediaModel()
        Mockito.`when`(mediaMock.rating()).thenReturn("")
        bindDataToView(mediaMock)
        return this
    }

    infix fun areVisible(func: MediaItemViewResult.() -> Unit) = MediaItemViewResult().apply { func() }

    private fun mockMediaModel(): Media {
        val mediaMock = Mockito.mock(Media::class.java)
        Mockito.`when`(mediaMock.poster()).thenReturn("")
        Mockito.`when`(mediaMock.title()).thenReturn("A media title")
        Mockito.`when`(mediaMock.rating()).thenReturn("6.8")
        return mediaMock
    }

    private fun bindDataToView(data: Media) {
        rule.activity.setObj(data)
        doWait(300L)
    }

    private fun itemViewModel() = MockObjects.mediaItem()

}

class MediaItemViewResult {

    fun posterError() {
        posterState(R.drawable.ic_broken_image)
    }

    fun mediaPoster() {
        displayed {
            id(R.id.img_media_item_poster)
        }
    }

    fun noTitleText() {
        displayed {
            allOf {
                id(R.id.txt_media_item_title)
                text(R.string.media_item_no_title)
            }
        }
    }

    fun mediaTitle() {
        displayed {
            id(R.id.txt_media_item_title)
        }
    }

    fun mediaRating() {
        displayed {
            id(R.id.txt_media_item_rating)
        }
    }

    fun noRatingText() {
        displayed {
            allOf {
                id(R.id.txt_media_item_rating)
                text(R.string.media_item_no_rating)
            }
        }
    }

    private fun posterState(@DrawableRes image: Int) {
        displayed {
            allOf {
                id(R.id.img_media_item_poster)
                image(image)
            }
        }
    }

}