package com.matias.cogui.common.mvp

interface BasePresenter<V : BaseView> {

    val isBound: Boolean
    fun bind(view: V)
    fun unbind()

}