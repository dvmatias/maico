package com.matias.cogui.common.dependencyinjection.presentation

import android.app.Activity
import android.content.Context
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.google.gson.Gson
import com.matias.cogui.common.utils.managers.SharedPreferencesManager
import com.matias.cogui.common.mvp.BaseView
import com.matias.cogui.common.utils.ImageLoader
import com.matias.cogui.common.utils.managers.DialogsManager
import dagger.Module
import dagger.Provides

@Module
class PresentationModule(
    private var view: BaseView,
    private var activity: FragmentActivity
) {

    @Provides
    fun getFragmentManager(): FragmentManager = activity.supportFragmentManager


    @Provides
    fun getActivity(): Activity = activity

    @Provides
    fun getContext(): Context = activity

    @Provides
    fun getView(): BaseView = view

    @Provides
    fun getSharedPreferencesManager(): SharedPreferencesManager = SharedPreferencesManager(getContext())

    @Provides
    fun getImageLoader(): ImageLoader = ImageLoader(getActivity())

    @Provides
    fun getGson(): Gson = Gson()

    @Provides
    fun getDialogsManager(fragmentManager: FragmentManager): DialogsManager = DialogsManager(fragmentManager)

}