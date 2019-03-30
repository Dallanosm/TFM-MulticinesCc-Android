package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler

class CommentsPresenter(view: CommentsPresenter.View, errorHandler: ErrorHandler) :
        Presenter<CommentsPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        // Nothing to do yet
    }

    override fun resume() {
        // Nothing to do yet
    }

    override fun stop() {
        // Nothing to do yet
    }

    override fun destroy() {
        // Nothing to do yet
    }

    fun addComment(text: String) {
        // Not implemented yet
    }

    fun onCloseClick() {
        view.finish()
    }

    interface View : Presenter.View {
        fun showComments()
        fun showEmptyContentView()
        fun finish()
    }

}