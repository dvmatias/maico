package com.matias.maico.common.dependencyinjection.presentation

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import com.matias.maico.common.mvp.BaseView
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(
    private var view: BaseView,
    private var fragmentManager: FragmentManager,
    private var activity: Activity
) {

    @Provides
    fun getActivity(): Activity = activity

    @Provides
    fun getContext(): Context = activity

}