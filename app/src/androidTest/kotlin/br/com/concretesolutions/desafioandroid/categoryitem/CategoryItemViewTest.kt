package br.com.concretesolutions.desafioandroid.categoryitem

import android.support.test.runner.AndroidJUnit4
import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.manager.MediaManagerType.MOVIE
import br.com.concretesolutions.desafioandroid.ui.feature.MediaListActivity
import br.com.concretesolutions.desafioandroid.util.JsonFileReader
import br.com.concretesolutions.desafioandroid.viewmodel.CategoryViewModel
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.kappuccino.custom.intent.IntentMatcherInteractions.matchIntent
import br.com.concretesolutions.kappuccino.custom.recyclerView.RecyclerViewInteractions.recyclerView
import br.com.concretesolutions.requestmatcher.model.HttpMethod
import okhttp3.mockwebserver.MockResponse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CategoryItemViewTest : BaseViewTest<CategoryViewModel>(R.layout.v_category_item, launch = false ,obj = CategoryViewModel(R.string.popular, MOVIE)) {

    @Test
    fun categoryTitle_isVisible() {
        displayed {
            id(R.id.txt_category_title)
        }
    }

    @Test
    fun mediaHorizontalList_isVisible() {
        displayed {
            id(R.id.media_horizontal_list)
        }
    }

    @Test
    fun categoryTitle_shouldBe_Popular() {
        displayed {
            allOf {
                id(R.id.txt_category_title)
                text("Popular")
            }
        }
    }

    @Test
    fun lastItem_shouldBe_seeMore() {
        recyclerView(R.id.recycler_view) {
            atPosition(19) {
                scroll()
            }
        }
        displayed {
            text(R.string.see_more)
        }
    }

    @Test
    fun clickOnSeeMore_shouldOpenMediaList() {
        matchIntent {
            className(MediaListActivity::class.java.name)
            resultOk()
        }

        recyclerView(R.id.recycler_view) {
            atPosition(19) {
                scroll()
                click()
            }
        }

        matchIntent {
            className(MediaListActivity::class.java.name)
        }
    }

    @Before
    fun setUp() {
        val response = MockResponse().setResponseCode(200).setBody(JsonFileReader.readFixture("movie_page_200.json"))
        server.addResponse(response)
                .ifRequestMatches()
                .pathIs("/movie/popular")
                .queriesContain("page", "1")
                .methodIs(HttpMethod.GET)
        rule.launchActivity(super.intent())
    }

}