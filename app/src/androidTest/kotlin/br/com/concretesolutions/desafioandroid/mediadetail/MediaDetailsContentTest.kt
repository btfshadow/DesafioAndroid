package br.com.concretesolutions.desafioandroid.mediadetail

import br.com.concretesolutions.desafioandroid.R
import br.com.concretesolutions.desafioandroid.base.BaseViewTest
import br.com.concretesolutions.desafioandroid.mock.MockObjects
import br.com.concretesolutions.kappuccino.utils.doWait
import br.com.concretesolutions.repository.model.Media
import org.junit.Test

class MediaDetailsContentTest: BaseViewTest<Media>(R.layout.v_media_details_content, obj = MockObjects.mediaItem()) {

    @Test
    fun testInitial() {
//        rule.activity.setObj(MockObjects.mediaItem())
        doWait(5000L)
    }
}