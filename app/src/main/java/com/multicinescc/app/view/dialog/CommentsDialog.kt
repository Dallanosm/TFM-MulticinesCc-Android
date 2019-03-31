package com.multicinescc.app.view.dialog

import android.os.Bundle
import com.github.salomonbrys.kodein.Kodein
import com.github.salomonbrys.kodein.bind
import com.github.salomonbrys.kodein.instance
import com.github.salomonbrys.kodein.provider
import com.multicinescc.app.R
import com.multicinescc.app.extension.hideMe
import com.multicinescc.app.extension.showMe
import com.multicinescc.app.extension.toast
import com.multicinescc.app.models.CommentView
import com.multicinescc.app.presenter.CommentsPresenter
import kotlinx.android.synthetic.main.dialog_comments.*
import kotlinx.android.synthetic.main.view_toolbar.*

class CommentsDialog : RootDialog<CommentsPresenter.View>(), CommentsPresenter.View {

    companion object {
        const val MOVIE_ID = "MOVIE_ID"

        fun newInstance(movieId: Long): CommentsDialog {
            val commentsDialog = CommentsDialog()

            val extras = Bundle()
            extras.putLong(MOVIE_ID, movieId)

            commentsDialog.arguments = extras
            return commentsDialog
        }
    }

    override val layoutResourceId: Int = R.layout.dialog_comments

    override val presenter: CommentsPresenter by instance()

    override val fragmentModule: Kodein.Module = Kodein.Module {
        bind<CommentsPresenter>() with provider {
            CommentsPresenter(
                    retrieveCommentsByMovieUseCase = instance(),
                    view = this@CommentsDialog,
                    errorHandler = instance())
        }
    }

    override fun initializeUI() {
        toolbarTitle.text = getString(R.string.comments)
    }

    override fun registerListeners() {
        close.setOnClickListener { presenter.onCloseClick() }
    }

    override fun getMovieId(): Long = arguments?.getLong(MOVIE_ID)
            ?: throw IllegalArgumentException("Movie id must be long")


    override fun showProgress() = progressView.showMe()
    override fun hideProgress() = progressView.hideMe()

    override fun showError(error: String) = toast(error)
    override fun showError(errorId: Int) = toast(errorId)
    override fun showMessage(message: String) = toast(message)
    override fun showMessage(messageId: Int) = toast(messageId)

    override fun showComments(comments: List<CommentView>) {
        emptyContentView.hideMe()
        commentsView.showMe()
        comments.forEach {
            showMessage("EO ${it.value}")
        }
    }

    override fun showEmptyContentView() {
        emptyContentView.showMe()
        commentsView.hideMe()
    }

    override fun finish() {
        dismiss()
    }

}