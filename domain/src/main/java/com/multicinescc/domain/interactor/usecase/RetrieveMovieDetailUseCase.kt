package com.multicinescc.domain.interactor.usecase

import com.multicinescc.domain.executor.Executor
import com.multicinescc.domain.interactor.SingleInteractor
import com.multicinescc.domain.models.MovieDetail
import com.multicinescc.domain.repository.MoviesRepository

class RetrieveMovieDetailUseCase(private val repository: MoviesRepository, executor: Executor) :
        SingleInteractor<MovieDetail>(executor = executor) {

    fun execute(id: Long, onSuccess: (MovieDetail) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess = onSuccess, onError = onError, single = repository.getMovie(id))
    }

}