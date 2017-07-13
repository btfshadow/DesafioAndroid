package br.com.concretesolutions.desafioandroid.mediaitem

import android.support.annotation.DrawableRes
import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.ViewTestActivity
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.utils.doWait
import org.mockito.Mockito

fun mediaItem(rule: ActivityTestRule<ViewTestActivity>, func: MediaItemViewRobot.() -> Unit) = MediaItemViewRobot(rule).apply { func() }

class MediaItemViewRobot(val rule: ActivityTestRule<ViewTestActivity>) {

    fun everythingIsOk() : MediaItemViewRobot {
        bindDataToView(itemViewModel())
        return this
    }

    fun noPoster(): MediaItemViewRobot {
        val viewModelMock = mockViewModel()
        Mockito.`when`(viewModelMock.poster).thenReturn("")
        bindDataToView(viewModelMock)
        return this
    }

    fun errorLoadingPoster(): MediaItemViewRobot {
        val viewModelMock = mockViewModel()
        Mockito.`when`(viewModelMock.poster).thenReturn("invalid_url")
        bindDataToView(viewModelMock)
        return this
    }

    fun noTitle() : MediaItemViewRobot {
        val viewModelMock = mockViewModel()
        Mockito.`when`(viewModelMock.title).thenReturn("")
        bindDataToView(viewModelMock)
        return this
    }

    fun noRating() : MediaItemViewRobot {
        val viewModelMock = mockViewModel()
        Mockito.`when`(viewModelMock.rating).thenReturn("")
        bindDataToView(viewModelMock)
        return this
    }

    infix fun areVisible(func: MediaItemViewResult.() -> Unit) = MediaItemViewResult().apply { func() }

    private fun mockViewModel(): MediaItemViewModel {
        val viewModelMock = Mockito.mock(MediaItemViewModel::class.java)
        Mockito.`when`(viewModelMock.poster).thenReturn("")
        Mockito.`when`(viewModelMock.title).thenReturn("A media title")
        Mockito.`when`(viewModelMock.rating).thenReturn("6.8")
        return viewModelMock
    }

    private fun bindDataToView(viewModel: MediaItemViewModel) {
        rule.activity.setObj(viewModel)
        doWait(300L)
    }

    private fun itemViewModel(): MediaItemViewModel {
        return MediaItemViewModel(MockObjects.mediaItem())
    }


}

class MediaItemViewResult {

    fun posterError() {
        posterState(R.drawable.ic_broken_image)
    }

    fun reloadPoster() {
        posterState(R.drawable.ic_refresh)
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