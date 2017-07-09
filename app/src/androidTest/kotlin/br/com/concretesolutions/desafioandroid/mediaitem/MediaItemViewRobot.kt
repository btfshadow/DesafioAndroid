package br.com.concretesolutions.desafioandroid.mediaitem

import android.support.test.rule.ActivityTestRule
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.ViewTestActivity
import br.com.concretesolutions.desafioandroid.mocks.MockObjects
import br.com.concretesolutions.desafioandroid.viewmodel.MediaItemViewModel
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.utils.doWait

fun mediaItem(rule: ActivityTestRule<ViewTestActivity>, func: MediaItemViewRobot.() -> Unit) = MediaItemViewRobot(rule).apply { func() }

class MediaItemViewRobot(val rule: ActivityTestRule<ViewTestActivity>) {

    fun everythingIsOk() : MediaItemViewRobot {
        bindDataToView(itemViewModel())
        return this
    }

    infix fun areVisible(func: MediaItemViewResult.() -> Unit) = MediaItemViewResult().apply { func() }

    private fun bindDataToView(viewModel: MediaItemViewModel) {
        rule.activity.setObj(viewModel)
        doWait(300L)
    }

    private fun itemViewModel(): MediaItemViewModel {
        return MediaItemViewModel(MockObjects.mediaItem())
    }

}

class MediaItemViewResult {

    fun mediaPoster() {
        displayed {
            id(R.id.img_media_item_poster)
        }
    }

    fun mediaName() {
        displayed {
            id(R.id.txt_media_item_title)
        }
    }

    fun mediaRating() {
        displayed {
            id(R.id.txt_media_item_rating)
        }
    }

}