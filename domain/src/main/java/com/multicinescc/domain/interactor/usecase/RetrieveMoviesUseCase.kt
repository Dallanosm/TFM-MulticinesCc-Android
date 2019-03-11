package com.multicinescc.domain.interactor.usecase

import com.multicinescc.domain.executor.Executor
import com.multicinescc.domain.interactor.SingleInteractor
import com.multicinescc.domain.models.Movie
import com.multicinescc.domain.repository.MoviesRepository

class RetrieveMoviesUseCase(private val repository: MoviesRepository, executor: Executor) :
        SingleInteractor<List<Movie>>(executor = executor) {

    fun execute(onSuccess: (List<Movie>) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess = onSuccess, onError = onError, single = repository.getMovies())
    }

}