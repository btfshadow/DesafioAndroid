package br.com.concretesolutions.desafioandroid.mediadetail

import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.kappuccino.assertions.VisibilityAssertions.displayed
import br.com.concretesolutions.repository.model.Media
import org.junit.Test

class MediaDetailsContentTest: BaseViewTest<Media>(R.layout.v_media_details_content, obj = MockObjects.mediaItem()) {

    @Test
    fun allViewsAreVisible() {
        displayed {
            id(R.id.img_media_details_poster)
            id(R.id.txt_media_details_rating)
            id(R.id.rb_media_details_rating_bar)
            id(R.id.txt_media_details_overview)
            id(R.id.txt_media_details_overview_text)
        }
    }
}