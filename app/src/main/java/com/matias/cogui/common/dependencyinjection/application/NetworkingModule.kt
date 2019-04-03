package com.matias.cogui.common.dependencyinjection.application

import android.content.Context
import com.matias.cogui.common.utils.managers.InternetConnectivityManager
import dagger.Module
import dagger.Provides

@Module
class NetworkingModule(val context: Context) {

    @Provides
    fun getInternetConnectivityManager(): InternetConnectivityManager
            = InternetConnectivityManager(context)

}