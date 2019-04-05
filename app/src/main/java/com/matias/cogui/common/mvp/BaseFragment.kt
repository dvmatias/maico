package com.matias.cogui.common.mvp

import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v4.app.Fragment
import com.matias.cogui.common.MyApplication
import com.matias.cogui.common.dependencyinjection.application.ApplicationComponent
import com.matias.cogui.common.dependencyinjection.presentation.PresentationComponent
import com.matias.cogui.common.dependencyinjection.presentation.PresentationModule

open class BaseFragment : Fragment(), BaseView {

    private var isInjectorUsed: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @UiThread
    protected fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) {
            throw RuntimeException("There is no need to use injector more than once")
        }
        isInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(
            PresentationModule(this, activity!!)
        )
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (activity!!.application as MyApplication).getApplicationComponent()
    }
}