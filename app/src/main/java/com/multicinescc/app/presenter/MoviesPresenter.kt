package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.mappers.toView
import com.multicinescc.app.models.MovieView
import com.multicinescc.domain.interactor.usecase.RetrieveMoviesUseCase

class MoviesPresenter(private val retrieveMoviesUseCase: RetrieveMoviesUseCase,
                      view: MoviesPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MoviesPresenter.View>(view = view, errorHandler = errorHandler) {

    override fun initialize() {
        view.showProgress()
        retrieveMoviesUseCase.execute(
                onSuccess = { movies ->
                    if (movies.isNotEmpty()) {
                        view.showMovies(movies.map { it.toView() })
                    }
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {
        //Nothing to do yet
    }

    override fun stop() {
        //Nothing to do yet
    }

    override fun destroy() {
        retrieveMoviesUseCase.clear()
    }

    interface View : Presenter.View {
        fun showMovies(movies: List<MovieView>)
    }
}