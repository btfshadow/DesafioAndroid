package br.com.concretesolutions.desafioandroid.categoryitem

import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.mock.RequestMock
import br.com.concretesolutions.desafioandroid.mock.mockRequest
import br.com.concretesolutions.desafioandroid.ui.feature.detail.MediaDetailActivity
import br.com.concretesolutions.desafioandroid.ui.feature.list.MediaListActivity
import br.com.concretesolutions.kappuccino.actions.ClickActions.click
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.notDisplayed
import br.com.concretesolutions.kappuccino.custom.intent.IntentMatcherInteractions.matchIntent
import br.com.concretesolutions.kappuccino.custom.recyclerView.RecyclerViewInteractions.recyclerView
import br.com.concretesolutions.requestmatcher.RequestMatcherRule

fun categoryItem(server: RequestMatcherRule, testClass: CategoryItemViewTest, func: CategoryItemRobot.() -> Unit) = CategoryItemRobot(server, testClass).apply { func() }

class CategoryItemRobot(val server: RequestMatcherRule, val testClass: CategoryItemViewTest) {

    fun requestReturn(code: RequestMock.Code): CategoryItemRobot {
        request(code)
        openFragment()
        return this
    }

    fun scrollToLastPosition(): CategoryItemRobot {
        request(RequestMock.Code.SUCCESS)
        openFragment()
        recyclerView(R.id.recycler_view) {
            atPosition(19) {
                scroll()
            }
        }
        return this
    }

    infix fun isVisible(func: CategoryItemResult.() -> Unit): CategoryItemResult {
        return CategoryItemResult().apply { func() }
    }

    infix fun clickMediaItem(func: CategoryItemResult.() -> Unit): CategoryItemResult {
        request(RequestMock.Code.SUCCESS)
        openFragment()
        clickItem(0, MediaDetailActivity::class.java.name)
        return CategoryItemResult().apply { func() }
    }

    infix fun seeMore(func: CategoryItemResult.() -> Unit): CategoryItemResult {
        request(RequestMock.Code.SUCCESS)
        openFragment()
        clickItem(19, MediaListActivity::class.java.name)
        return CategoryItemResult().apply { func() }
    }

    infix fun retry(func: CategoryItemResult.() -> Unit): CategoryItemResult {
        request(RequestMock.Code.SUCCESS)
        click {
            id(R.id.txt_error_view)
        }
        return CategoryItemResult().apply { func() }
    }

    private fun openFragment() {
        testClass.rule.launchActivity(testClass.getIntent())
    }

    private fun request(code: RequestMock.Code) {
        mockRequest(server) {
            movies {
                popular(code)
            }
        }
    }

    private fun clickItem(position: Int = 0, className: String) {
        matchIntent {
            className(className)
            resultOk()
        }

        recyclerView(R.id.recycler_view) {
            atPosition(position) {
                scroll()
                click()
            }
        }

        matchIntent {
            className(className)
        }
    }
}

class CategoryItemResult {
    fun errorView(isVisible: Boolean) {
        if (isVisible)
            displayed {
                id(R.id.txt_error_view)
            }
        else
            notDisplayed {
                id(R.id.txt_error_view)
            }
    }

    fun detailsOpened() {

    }

    fun listOpened() {

    }

    fun seeMore(isVisible: Boolean) {
        if (isVisible)
            displayed {
                text(R.string.see_more)
            }
        else
            notDisplayed {
                text(R.string.see_more)
            }
    }

    fun listIsVisible() {
        displayed {
            id(R.id.media_horizontal_list)
        }
    }


}