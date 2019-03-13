package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.mappers.toView
import com.multicinescc.app.models.MovieDetailView
import com.multicinescc.domain.interactor.usecase.RetrieveMovieDetailUseCase
import com.multicinescc.domain.models.MovieDetail

class MovieDetailsPresenter(private val retrieveMovieDetailUseCase: RetrieveMovieDetailUseCase,
                            view: MovieDetailsPresenter.View, errorHandler: ErrorHandler) :
        Presenter<MovieDetailsPresenter.View>(view = view, errorHandler = errorHandler) {

    lateinit var movie: MovieDetail
    override fun initialize() {
        view.showProgress()
        retrieveMovieDetailUseCase.execute(
                id = view.getMovieId(),
                onSuccess = {
                    movie = it
                    view.showDetails(movie.toView())
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

    fun onSeeTrailerClicked() {
        view.showTrailer(movie.trailer.split("embed/")[1])
    }

    interface View : Presenter.View {
        fun getMovieId(): Long
        fun showDetails(movieDetail: MovieDetailView)
        fun showTrailer(id: String)
    }
}