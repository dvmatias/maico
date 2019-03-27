package com.matias.maico.common

import android.app.Application
import com.matias.maico.common.dependencyinjection.application.ApplicationComponent
import com.matias.maico.common.dependencyinjection.application.ApplicationModule
import com.matias.maico.common.dependencyinjection.application.DaggerApplicationComponent
import com.matias.maico.common.dependencyinjection.application.NetworkingModule

class MyApplication : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        setup()
    }

    private fun setup() {
        @Suppress("DEPRECATION")
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule())
            .networkingModule(
                NetworkingModule(
                    applicationContext
                )
            )
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent = applicationComponent
}