package com.matias.maico.common.dependencyinjection.application

import android.app.Application
import dagger.Module

@Module
class ApplicationModule {

    private lateinit var application: Application

    fun ApplicationModule(application: Application) {
        this.application = application
    }
}