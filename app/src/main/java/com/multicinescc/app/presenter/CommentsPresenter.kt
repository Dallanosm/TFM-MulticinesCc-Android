package com.multicinescc.app.presenter

import com.multicinescc.app.error.ErrorHandler
import com.multicinescc.app.mappers.toView
import com.multicinescc.app.models.CommentView
import com.multicinescc.domain.interactor.usecase.RetrieveCommentsByMovieUseCase
import com.multicinescc.domain.interactor.usecase.SendNewCommenUseCase

class CommentsPresenter(private val retrieveCommentsByMovieUseCase: RetrieveCommentsByMovieUseCase,
                        private val sendNewCommenUseCase: SendNewCommenUseCase,
                        view: CommentsPresenter.View, errorHandler: ErrorHandler) :
        Presenter<CommentsPresenter.View>(view = view, errorHandler = errorHandler) {

    private val movieId by lazy { view.getMovieId() }

    override fun initialize() {
        view.showProgress()
        retrieveCommentsByMovieUseCase.execute(
                movieId = movieId,
                onSuccess = { comments ->
                    if (comments.isNotEmpty()) {
                        view.showComments(comments.map { it.toView() })
                    } else {
                        view.showEmptyContentView()
                    }
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    override fun resume() {
        // Nothing to do yet
    }

    override fun stop() {
        retrieveCommentsByMovieUseCase.clear()
        sendNewCommenUseCase.clear()
    }

    override fun destroy() {
        // Nothing to do yet
    }

    fun addComment(newComment: String) {
        view.showProgress()
        sendNewCommenUseCase.execute(
                movieId = movieId,
                newComment = newComment,
                onSuccess = { comments ->
                    view.clearNewCommentInput()
                    if (comments.isNotEmpty()) {
                        view.showComments(comments.map { it.toView() })
                    } else {
                        view.showEmptyContentView()
                    }
                    view.hideProgress()
                },
                onError = onError { view.showError(it) }
        )
    }

    fun onCloseClick() {
        view.finish()
    }

    interface View : Presenter.View {
        fun getMovieId(): Long
        fun showComments(comments: List<CommentView>)
        fun showEmptyContentView()
        fun finish()
        fun clearNewCommentInput()
    }

}