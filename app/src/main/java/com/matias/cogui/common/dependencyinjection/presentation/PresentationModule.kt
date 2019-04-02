package com.matias.cogui.common.dependencyinjection.presentation

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentManager
import com.matias.cogui.common.managers.SharedPreferencesManager
import com.matias.cogui.common.mvp.BaseView
import com.matias.cogui.common.utils.ImageLoader
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

    @Provides
    fun getView(): BaseView = view

    @Provides
    fun getSharedPreferencesManager(): SharedPreferencesManager
            = SharedPreferencesManager(getContext())

	@Provides
	fun getImageLoader(): ImageLoader = ImageLoader(getActivity())

}