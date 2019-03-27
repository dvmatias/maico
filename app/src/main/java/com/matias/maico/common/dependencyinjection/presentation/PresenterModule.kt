package com.matias.maico.common.dependencyinjection.presentation

import com.matias.maico.common.mvp.BaseView
import com.matias.maico.screens.splash.CheckCredentialsInteractor
import com.matias.maico.screens.splash.CheckNetworkStatusInteractor
import com.matias.maico.screens.splash.SplashContract
import com.matias.maico.screens.splash.SplashPresenter
import dagger.Module
import dagger.Provides

@Module
class PresenterModule {

    @Provides
    fun getSplashPresenter(
        view: BaseView,
        checkNetworkStatusInteractor: CheckNetworkStatusInteractor,
        checkCredentialsInteractor: CheckCredentialsInteractor
    ): SplashPresenter =
        SplashPresenter(view as SplashContract.View, checkNetworkStatusInteractor, checkCredentialsInteractor)

}