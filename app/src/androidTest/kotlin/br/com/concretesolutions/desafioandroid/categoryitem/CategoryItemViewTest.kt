package br.com.concretesolutions.desafioandroid.categoryitem

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.manager.MediaManagerType.MOVIE
import br.com.concretesolutions.desafioandroid.mock.RequestMock.Code.ERROR
import br.com.concretesolutions.desafioandroid.mock.RequestMock.Code.SUCCESS
import br.com.concretesolutions.desafioandroid.mock.mockRequest
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryItemViewTest : BaseViewTest<CategoryViewModel>(R.layout.v_category_item, launch = false, obj = CategoryViewModel(R.string.popular, MOVIE)) {

    @Test
    fun categoryTitle_isVisible() {
        openFragmentDefaultState()
        displayed {
            id(R.id.txt_category_title)
        }
    }

    @Test
    fun mediaHorizontalList_isVisible() {
        openFragmentDefaultState()
        displayed {
            id(R.id.media_horizontal_list)
        }
    }

    @Test
    fun categoryTitle_shouldBe_Visible() {
        openFragmentDefaultState()
        displayed {
            allOf {
                id(R.id.txt_category_title)
                text("Popular")
            }
        }
    }

    @Test
    fun lastItem_shouldBe_seeMore() {
        categoryItem(server, this) {
            scrollToLastPosition()
        } isVisible {
            seeMore(true)
        }
    }

    @Test
    fun clickOnSeeMore_shouldOpenMediaList() {
        categoryItem(server, this) {
        } seeMore {
            listOpened()
        }
    }

    @Test
    fun clickOnMediaItem_shouldOpenMediaDetails() {
        categoryItem(server, this) {
        } clickMediaItem {
            detailsOpened()
        }

    }

    @Test
    fun onRequestError_shouldDisplayErrorView() {
        categoryItem(server, this) {
            requestReturn(ERROR)
        } isVisible {
            errorView(true)
        }
    }

    @Test
    fun clickOnRetry_shouldRetryRequest() {
        categoryItem(server, this) {
            requestReturn(ERROR)
        } retry {
            listIsVisible()
        }
    }

    fun getIntent() = super.intent()

    private fun openFragmentDefaultState() {
        mockRequest(server) {
             movies {
                 popular(SUCCESS)
             }
        }
        rule.launchActivity(super.intent())
    }

}