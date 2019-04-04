package com.matias.cogui.common.dependencyinjection.application

import android.app.Application
import com.google.i18n.phonenumbers.PhoneNumberUtil
import com.matias.cogui.common.utils.managers.PhoneManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    private lateinit var application: Application

    fun ApplicationModule(application: Application) {
        this.application = application
    }

    @Singleton
    @Provides
    fun getPhoneNumberUtil(): PhoneNumberUtil = PhoneNumberUtil.getInstance()

    @Singleton
    @Provides
    fun getPhoneManager(phoneNumberUtil: PhoneNumberUtil): PhoneManager = PhoneManager(phoneNumberUtil)

}