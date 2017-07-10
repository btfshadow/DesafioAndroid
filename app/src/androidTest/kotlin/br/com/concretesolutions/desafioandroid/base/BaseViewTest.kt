package br.com.concretesolutions.desafioandroid.base

import android.content.Intent
import android.os.Parcelable
import android.support.annotation.LayoutRes
import br.com.concretesolutions.desafioandroid.ViewTestActivity


abstract class BaseViewTest<out T : Parcelable>(@LayoutRes private val layoutId: Int, val isDataBinding: Boolean = true, launch: Boolean = true, val obj: T? = null): BaseActivityTest<ViewTestActivity>(launch, ViewTestActivity::class.java) {

    override fun intent(): Intent {
        return ViewTestActivity.intent(layoutId, isDataBinding, obj)
    }

}