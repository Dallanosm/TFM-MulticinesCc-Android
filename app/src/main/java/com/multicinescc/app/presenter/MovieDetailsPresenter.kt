package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.models.MovieDetailView

class MovieDetailsPresenter(view: MovieDetailsPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MovieDetailsPresenter.View>(view = view, errorHandler = errorHandler) {

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

    interface View : Presenter.View {
        fun showDetails(movieDetail: MovieDetailView)
    }
}