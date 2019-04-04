package com.matias.cogui.common.dependencyinjection.application

import android.app.Application
import com.google.i18n.phonenumbers.PhoneNumberUtil
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule {

    private lateinit var application: Application

    fun ApplicationModule(application: Application) {
        this.application = application
    }

    @Provides
    fun getPhoneNumberUtil(): PhoneNumberUtil = PhoneNumberUtil.getInstance()

}