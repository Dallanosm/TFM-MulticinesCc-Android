package com.multicinescc.domain.interactor.usecase

import com.multicinescc.domain.executor.Executor
import com.multicinescc.domain.interactor.SingleInteractor
import com.multicinescc.domain.models.Comment
import com.multicinescc.domain.repository.MoviesRepository

class RetrieveCommentsByMovieUseCase(private val repository: MoviesRepository, executor: Executor) :
        SingleInteractor<List<Comment>>(executor = executor) {

    fun execute(movieId: Long, onSuccess: (List<Comment>) -> Unit, onError: (Throwable) -> Unit) {
        super.execute(onSuccess = onSuccess, onError = onError, single = repository.getComments(movieId))
    }

}