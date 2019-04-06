package com.matias.cogui.common.dependencyinjection.presentation

import com.matias.cogui.common.views.LoadingDialogFragment
import dagger.Module
import dagger.Provides

@Module
class DialogModule {

	@Provides
	fun getLoadingDialogFragment(): LoadingDialogFragment = LoadingDialogFragment.newInstance()

}