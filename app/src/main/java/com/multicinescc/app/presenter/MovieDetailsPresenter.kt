package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.mappers.toView
import com.multicinescc.app.models.MovieDetailView
import com.multicinescc.domain.interactor.usecase.RetrieveMovieDetailUseCase

class MovieDetailsPresenter(private val retrieveMovieDetailUseCase: RetrieveMovieDetailUseCase,
                            view: MovieDetailsPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MovieDetailsPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        view.showProgress()
        retrieveMovieDetailUseCase.execute(
                id = view.getMovieId(),
                onSuccess = {
                    view.showDetails(it.toView())
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {
        // Nothing to do yet
    }

    override fun stop() {
        // Nothing to do yet
    }

    override fun destroy() {
        retrieveMovieDetailUseCase.clear()
    }

    interface View : Presenter.View {
        fun getMovieId(): Long
        fun showDetails(movieDetail: MovieDetailView)
    }
}