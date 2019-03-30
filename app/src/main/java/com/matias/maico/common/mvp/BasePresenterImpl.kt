package com.matias.maico.common.mvp

open class BasePresenterImpl<V: BaseView> : BasePresenter<V> {

    var view: V? = null

    override fun bind(view: V) {
        this.view = view
    }

    override fun unbind() {
        this.view = null
    }

    override val isBound: Boolean
        get() = view != null

}
